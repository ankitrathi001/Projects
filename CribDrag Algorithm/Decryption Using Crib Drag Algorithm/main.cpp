#include <iostream>
#include<fstream>
#include<sstream>
#include<map>
#include<vector>
#include <unistd.h>
#include <sys/types.h>
#include <pwd.h>

using namespace std;

struct passwd *pw = getpwuid(getuid());
const char *homedir = pw->pw_dir;
std::string h = std::string(homedir);

/* Function Declarations of the functions used*********************************/
void createCrib();
void createDictionary();
string hexToString(string);
int hexCharToInt(char);
string stringToHex(string);
string xorTwoHexStrings(string, string);
int isReadable(string);
int decryptUsingCribMain(string, string);
int decryptUsingCrib(string, string, string);
vector<string> checkSentence(string);
int containsCharacter();
int checkWordsInSentence(string);
int addThePad(string);
string Hex2Bin(string);
string binaryToHex(string);
/* Function Declaration ends *************************************************/

/* Hashmap and Vector declaration for creating dictionary and storing results*/
vector<string> crib;
vector<string> result;
map<char, vector<string> > FirstCharacterDictionary;
vector<string> Dictionary;
vector<string> Pad;
vector<string> CipherText;
/* Hashmap and Vector declaration ends ***************************************/

/* Global Variables **********************************************************/
int found =0;
int MaxFound=1;
string HexC1xorC2;
string CipherText1="";
string CipherText2="";
/* Global Variables ends *****************************************************/

int main()
{
    char choice ='y';
    int count =0;

    while(choice=='y'){
        string temp=h+"/cipher00";
        ifstream in_file;
        ostringstream oss1;
        oss1 << count;
        cout << temp.append(oss1.str())<< " Added" << endl;
        in_file.open(temp.c_str());
        string str;
        getline(in_file,str);
        CipherText.push_back(binaryToHex(str));
        in_file.close();
        count++;
        cout << "Do you want to add more files (y/n): ";
        cin >> choice;
    }

    if(count < 2){
        cout << "2 files required for decrypting the message\n";
    }

    CipherText1 = CipherText[0];
    CipherText2 = CipherText[1];

    HexC1xorC2 = xorTwoHexStrings(CipherText1,CipherText2);

    createDictionary();
    createCrib();

    decryptUsingCribMain(HexC1xorC2,"");


    for(unsigned int i=0;i<Pad.size();i++){
        for(unsigned int j=0;j<CipherText.size();j++){
            ofstream of_file;
            string t = h+"/msg0";
            ostringstream oss1;
            oss1 << i;
            ostringstream oss2;
            oss2 << j;
            of_file.open((h+"/pad").c_str());
            of_file << Hex2Bin(Pad[i]);
            of_file.close();
            of_file.open(t.append(oss1.str()).append(oss2.str()).c_str());
            of_file << hexToString(xorTwoHexStrings(Pad[i],CipherText[j]));
            of_file.close();
        }
        cout << "Result " << i+1 << " = " << hexToString(xorTwoHexStrings(CipherText1, Pad[i])) << "-----" << hexToString(xorTwoHexStrings(CipherText2, Pad[i])) <<"\n";
    }
    return 0;
}

/* Creating the dictionary for seraching
There are 2 dictionaries : (1) dictionary with first character as the key
                           (2) The complete words file ***********************/
void createDictionary(){
    ifstream in_file;
    in_file.open("/usr/share/dict/words");
    string str;
    while(getline(in_file,str)){
        //if(str.length()>1)
        FirstCharacterDictionary[str.at(0)].push_back(str);
        Dictionary.push_back(str);
    }
    in_file.close();
}
/* Dictionary ends **********************************************************/

/* Creatings cribs vector to be used in the program *************************/
void createCrib(){
    ifstream in_file;
    in_file.open("/usr/share/dict/words");
    string str;
    while(getline(in_file,str)){
        if(str.length()>1)
            crib.push_back(str);
    }
    in_file.close();
}
/* Cribs ends ***************************************************************/

/* Checking and adding one time pad to Pad vector****************************/
int addThePad(string result){
    string pad="";
    int flag=0;
    if(checkWordsInSentence(hexToString(xorTwoHexStrings(xorTwoHexStrings(CipherText1,stringToHex(result)), CipherText2))))
        pad=xorTwoHexStrings(CipherText1,stringToHex(result));
    else
        pad=xorTwoHexStrings(CipherText2,stringToHex(result));

    for(unsigned int i=2;i<CipherText.size();i++){
        if(!checkWordsInSentence(hexToString(xorTwoHexStrings(pad, CipherText[i]))))
            return 0;
    }

    for(unsigned int i=0;i<Pad.size();i++){
        if(Pad[i].compare(pad)==0){
            flag=1;
            break;
        }
    }
    if(flag==1)
        return 0;
    else
    {
        Pad.push_back(pad);
        return 1;
    }
}
/* Adding pad ends**********************************************************/
/* Function to XOR two hex strings******************************************/
string xorTwoHexStrings(string str1, string str2){
    std::stringstream XORString;
    unsigned int minLength = str2.length();
    if(str1.length()<minLength)
        minLength=str1.length();
    for(int i=0;i<minLength;i++){
        XORString << hex << (hexCharToInt(str1[i])^hexCharToInt(str2[i]));
    }
    return XORString.str();
}
/* Function to convert ascii string to Hex string *************************/
string stringToHex(string str){
    std::stringstream HexString;
    for(unsigned int i=0;i<str.length();i++){
        HexString << hex << (int)str.at(i);
    }
    return HexString.str();
}
/* Function to convert HEX string to ASCII string ************************/
string hexToString(string str){
    std::stringstream HexString;
    for(unsigned int i=0;i<str.length();i++){
        char a = str.at(i++);
        char b = str.at(i);
        int x = hexCharToInt(a);
        int y = hexCharToInt(b);
        HexString << (char)((16*x)+y);
    }
    return HexString.str();
}

int hexCharToInt(char a){
    if(a>='0' && a<='9')
        return(a-48);
    else if(a>='A' && a<='Z')
        return(a-55);
    else
        return(a-87);
}
/* Function to check if the string is readable or not *******************/
int isReadable(string str){
    for(unsigned int i=0;i<str.length();i++){
        //if(!((str.at(i) > 'A' && str.at(i) < 'Z') || (str.at(i) > 'a' && str.at(i) < 'z') || (str.at(i)==' ') || (str.at(i)=='.') || (str.at(i)==',') || (str.at(i)=='?') || (str.at(i)=='!') || (str.at(i)=='\n')))
        if(!((str.at(i) >= 'A' && str.at(i) <= 'Z') || (str.at(i) >= 'a' && str.at(i) <= 'z') || (str.at(i)==' ') || (str.at(i)=='\'')))
            return 0;
    }
    return 1;
}
/* Function to decrypt using the crib drag algorithm ********************/
int decryptUsingCribMain(string C1xorC2, string prevStr){
    if(found>=MaxFound)
        return 1;
    for(unsigned int i=0;i<crib.size();i++){
        string HexCrib = stringToHex(crib[i]);
        string c1xorc2xorcrib=hexToString(xorTwoHexStrings(HexCrib,C1xorC2));
        if(isReadable(c1xorc2xorcrib)){
            if(checkSentence(c1xorc2xorcrib).size()>0){
                if(found>=MaxFound)
                    break;
                if(decryptUsingCrib(C1xorC2,stringToHex(crib[i]), prevStr)==1)
                    break;
            }
        }
    }
}

int decryptUsingCrib(string C1xorC2, string HexCrib, string prevStr){
    string C1xorC2xorHexcrib = hexToString(xorTwoHexStrings(C1xorC2,HexCrib));
    if(HexCrib.length()>C1xorC2.length())
        return 0;
    // To check if length of the found sentence matches with the length of the cipher text as it cannot be greater
    if(HexCrib.length()==C1xorC2.length()){
        if(checkWordsInSentence(C1xorC2xorHexcrib) && checkWordsInSentence(hexToString(HexCrib))){
            string res = prevStr;
            res = res.append(C1xorC2xorHexcrib);
            if(checkWordsInSentence(hexToString(xorTwoHexStrings(stringToHex(res),HexC1xorC2))) && checkWordsInSentence(res)){
                if(addThePad(res)){
                found++;
                }
            }
            else
            {
                string res1 = prevStr;
                res1=res1.append(hexToString(HexCrib));
                if(checkWordsInSentence(res1) && checkWordsInSentence(hexToString(xorTwoHexStrings(stringToHex(res1), HexC1xorC2)))){
                    if(addThePad(res1)){
                        found++;
                    }
                }
            }

        }
    }
    if(found>=MaxFound)
        return 1;
    vector<string> newCribs = checkSentence(C1xorC2xorHexcrib);
    for(unsigned int i=0;i<newCribs.size();i++){
        if(found>=MaxFound)
            return 1;
        if(newCribs[i].length()<=C1xorC2.length()/2){
            // To check if XORing with the crib returns the previous crib
            // This could happen when the spaces of two messages coincide
            if(newCribs[i].compare(hexToString(xorTwoHexStrings(C1xorC2,HexCrib)))!=0){
                decryptUsingCrib(C1xorC2,stringToHex(newCribs[i]),prevStr);
            }
            else
            {
                string res = prevStr;
                res.append(newCribs[i]).append(" ");
                if(res.length()<C1xorC2.length()/2 && xorTwoHexStrings(C1xorC2.substr(newCribs[i].length()*2,2),"20").compare("20")==0){
                    decryptUsingCribMain(C1xorC2.substr((newCribs[i].length()+1)*2,C1xorC2.length()-(newCribs[i].length()+1)*2),res);

                }
            }
        }
    }
    //For the case when the word in first sentence ends 1 character before the word in second message ends or vice-versa
    //For ex: MSG1 = in the and worlds hello
    //        MSG2 = of meaning program that
    // here "worlds" ends an character before "program"
    if(C1xorC2xorHexcrib.at(C1xorC2xorHexcrib.length()-1)==' '){
        string t = C1xorC2xorHexcrib;
        if(checkWordsInSentence(t.substr(0,t.size()-1))){
            string res = prevStr;
            res.append(C1xorC2xorHexcrib);
            //res = res.substr(0,res.length()-1);
            if(res.length()<C1xorC2.length()/2)
                if(decryptUsingCribMain(C1xorC2.substr((C1xorC2xorHexcrib.length())*2,C1xorC2.length()-(C1xorC2xorHexcrib.length())*2),res)){}
                    //return 1;
        }
    }
}
/* Function to check the sentence and return predicted statements ************/
vector<string> checkSentence(string sentence){
    vector<string>TempDictionary;
    if(!isReadable(sentence))
        return TempDictionary;
    vector<string> words;
    unsigned int j=0;
    int flag=0;
    unsigned int i=0;
    string createCrib="";
    if(sentence.at(0)==' '){
        i=1;
        j=1;
        createCrib.append(" ");
    }
    for(;i<sentence.length();i++){
        if(sentence.at(i)==' '){
            if(j!=i){
                string tempstr = sentence.substr(j,i-j);
                words.push_back(tempstr);
            }
            j=i+1;
        }
    }
    if(j<sentence.length())
        words.push_back(sentence.substr(j,sentence.length()-j));
    else{
        words.push_back(" ");
    }
    for(unsigned int i=0;i<words.size();i++){
        if(words[i].at(0)!=' '){
            for(unsigned int j=0;j<FirstCharacterDictionary[words[i].at(0)].size();j++){
                if((FirstCharacterDictionary[words[i].at(0)][j].find(words[i]))  != std::string::npos){
                    flag=1;
                    break;
                }
                else
                    flag=0;
            }
        }
    }

    for(unsigned int i=0;i<words.size()-1;i++)
        createCrib.append(words[i]).append(" ");
    if(flag==1 && checkWordsInSentence(createCrib)){
        for(unsigned int i=0;i<FirstCharacterDictionary[words[words.size()-1].at(0)].size();i++){
            if((FirstCharacterDictionary[words[words.size()-1].at(0)][i].find(words[words.size()-1]))  != std::string::npos && FirstCharacterDictionary[words[words.size()-1].at(0)][i].substr(0,words[words.size()-1].length()).compare(words[words.size()-1])==0){
                string temp = createCrib;
                TempDictionary.push_back(temp.append(FirstCharacterDictionary[words[words.size()-1].at(0)][i]));
            }
        }
    }
    return TempDictionary;
}
/* Function to check words in the sentence ***************************************/
int checkWordsInSentence(string sentence){
    if(sentence.compare("")==0)
        return 1;
    if(!isReadable(sentence))
        return 0;
    vector<string> words;
    unsigned int j=0;
    int flag=0;
    unsigned int i=0;
    if(sentence.at(0)==' '){
        i=1;
        j=1;
    }
    for(;i<sentence.length();i++){
        if(sentence.at(i)==' '){
            if(j!=i){
            string tempstr = sentence.substr(j,i-j);
            words.push_back(tempstr);
            }
            j=i+1;
        }
    }
    if(j<sentence.length())
        words.push_back(sentence.substr(j,sentence.length()-j));

    for(unsigned int i=0;i<words.size();i++){
        for(unsigned int j=0;j<FirstCharacterDictionary[words[i].at(0)].size();j++){
            if((FirstCharacterDictionary[words[i].at(0)][j].compare(words[i]))  == 0){
                flag++;
                break;
            }
        }
    }
    if(flag == words.size())
        return 1;
    else
        return 0;
}
string Hex2Bin(string sHexValue){
    string binaryValue;

    for (int n = 0; n < sHexValue.size(); ++n)
    {
        switch (sHexValue[n])
        {
            case '0':
                binaryValue += "0000"; break;
            case '1':
                binaryValue += "0001"; break;
            case '2':
                binaryValue += "0010"; break;
            case '3':
                binaryValue += "0011"; break;
            case '4':
                binaryValue += "0100"; break;
            case '5':
                binaryValue += "0101"; break;
            case '6':
                binaryValue += "0110"; break;
            case '7':
                binaryValue += "0111"; break;
            case '8':
                binaryValue += "1000"; break;
            case '9':
                binaryValue += "1001"; break;
            case 'A': case 'a':
                binaryValue += "1010"; break;
            case 'B': case 'b':
                binaryValue += "1011"; break;
            case 'C': case 'c':
                binaryValue += "1100"; break;
            case 'D': case 'd':
                binaryValue += "1101"; break;
            case 'E': case 'e':
                binaryValue += "1110"; break;
            case 'F': case 'f':
                binaryValue += "1111"; break;
        }
    }
    return binaryValue;
}
string binaryToHex(string sBinary){
    string rest(""),tmp;
    for (int i=0;i<sBinary.length();i+=4)
    {
        tmp = sBinary.substr(i,4);
        if (!tmp.compare("0000"))
        {
            rest = rest + "0";
        }
        else if (!tmp.compare("0001"))
        {
            rest = rest + "1";
        }
        else if (!tmp.compare("0010"))
        {
            rest = rest + "2";
        }
        else if (!tmp.compare("0011"))
        {
            rest = rest + "3";
        }
        else if (!tmp.compare("0100"))
        {
            rest = rest + "4";
        }
        else if (!tmp.compare("0101"))
        {
            rest = rest + "5";
        }
        else if (!tmp.compare("0110"))
        {
            rest = rest + "6";
        }
        else if (!tmp.compare("0111"))
        {
            rest = rest + "7";
        }
        else if (!tmp.compare("1000"))
        {
            rest = rest + "8";
        }
        else if (!tmp.compare("1001"))
        {
            rest = rest + "9";
        }
        else if (!tmp.compare("1010"))
        {
            rest = rest + "a";
        }
        else if (!tmp.compare("1011"))
        {
            rest = rest + "b";
        }
        else if (!tmp.compare("1100"))
        {
            rest = rest + "c";
        }
        else if (!tmp.compare("1101"))
        {
            rest = rest + "d";
        }
        else if (!tmp.compare("1110"))
        {
            rest = rest + "e";
        }
        else if (!tmp.compare("1111"))
        {
            rest = rest + "f";
        }
        else
        {
            continue;
        }
    }
    return(rest);
}
//ENDS
