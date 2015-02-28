#include<iostream>
#include<fstream>
#include<sstream>
#include<vector>
#include<stdlib.h>
#include<time.h>
#include<string.h>
#include <unistd.h>
#include <sys/types.h>
#include <pwd.h>

using namespace std;

struct passwd *pw = getpwuid(getuid());
const char *homedir = pw->pw_dir;
std::string h = std::string(homedir);
/********************************Function Defination************************************/
string hexToString(string);
string stringToHex(string);
int hexCharToInt(char);
string xorTwoHexStrings(string, string);
string random_pad(int);
/*****************************Function Defination ends**********************************/

/********************************Function Declaration***********************************/
string hexToString(string str){         //Function to convert hex string to ASCII string
    std::stringstream HexString;
    for(int i=0;i<str.length();i++){
        char a = str.at(i++);
        char b = str.at(i);
        int x = hexCharToInt(a);
        int y = hexCharToInt(b);
        HexString << (char)((16*x)+y);
    }
    return HexString.str();
}
string xorTwoHexStrings(string str1, string str2){      //Function to XOR two hex strings
    std::stringstream XORString;
    int minLength = str2.length();
    if(str1.length()<minLength)
        minLength=str1.length();
    for(int i=0;i<minLength;i++){
        XORString << hex << (hexCharToInt(str1[i])^hexCharToInt(str2[i]));
    }
    return XORString.str();
}
int hexCharToInt(char a){
    if(a>='0' && a<='9')
        return(a-48);
    else if(a>='A' && a<='Z')
        return(a-55);
    else
        return(a-87);
}
string stringToHex(string str){                       //Function to convert string to hex
    std::stringstream HexString;
    for(int i=0;i<str.length();i++){
        HexString << hex << (int)str.at(i);
    }
    return HexString.str();
}
string random_pad(int length)
{
    srand(time(NULL));
    static const char alphanum[] =
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                "abcdefghijklmnopqrstuvwxyz";
    string str="";
    for (int i = 0; i < length; ++i) {
        str+= alphanum[rand() % (sizeof(alphanum) - 1)];
    }
    return str;
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
/*****************************Function Declaration ends*********************************/
int main(int argc, char* argv[])
{
    char choice ='y';
    int count =0;
    vector<string> filename;
    while(choice=='y'){
        string temp=h+"/msg00";
        ostringstream oss1;
        oss1 << count;
        cout << temp.append(oss1.str())<< " Added" << endl;

        filename.push_back(temp);
        count++;
        cout << "Do you want to add more files (y/n): ";
        cin >> choice;
    }
    string key = "";
    int length=0;
    if(filename.size()>0){
        ifstream in_file;
        in_file.open(filename[0].c_str());
        string str;
        getline(in_file,str);
        length = str.length();
        in_file.close();
        key = random_pad(length);

        ofstream of_file;
        string t = h+"/cipher00";
        of_file.open(t.append("0").c_str());
        of_file << Hex2Bin(xorTwoHexStrings(stringToHex(key),stringToHex(str)));
        of_file.close();
    }
    for(int i = 1; i<filename.size(); i++){
        ifstream in_file;
        in_file.open(filename[i].c_str());
        string str;
        getline(in_file,str);
        in_file.close();

        ofstream of_file;
        string t = h+"/cipher00";
        ostringstream oss;
        oss << i;
        of_file.open(t.append(oss.str()).c_str());
        of_file << Hex2Bin(xorTwoHexStrings(stringToHex(key),stringToHex(str)));
        of_file.close();
    }
    return 0;
}
