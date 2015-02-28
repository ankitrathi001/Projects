#include<stdio.h>
#include<stdlib.h>
struct node //this is the variable structure
{
char name;
int write;
int read;
}list[50]; //Assuming variable is a single character, so maximum number is 26, we
took 50
int max1[50]; //this will contain the return value of critical_function() for each
variable in a line,
//in a line there can be any number of characters.
int critical_section(char name, char type) //this is our main algorithm(code)
{
int i=0,flag=0,read=0,write=0,max=0;
while(list[i].name!='\0')
{
if(name==list[i].name) //to check if the variable has been
encountered before in the code
{
flag=1;
if(type=='r') //if the variable is of read type, then we will check
just the write value of
{ //that variable
max=list[i].write+1; // 1 is added just to give a better output
}
else //if the variable is of write type, we will check both the
values(read & write) and will
{ //take the maximum of them
read=list[i].read+1; // 1 is added just to give a better output
write=list[i].write+1; // 1 is added just to give a better output
if(write>read)
{
max=write;
}
else
{
max=read;
}
}
}
i++;
}
if(flag==0) //if the variable was not encountered before, we will add that
variable to the list
{
list[i].name=name;
list[i].read=1;
list[i].write=1;
max=1;
i++;
}
return max;
}
void main()
{
int q;
char line[128];
for(q=0;q<128;q++)
{
line[q]=';';
}
FILE *fp;
int i,j,k=0,l=0,m=0,max=0,n=0,flag=0,o=0,flag1=0;
fp = fopen("test2.txt","r+");
while ( fgets (line, sizeof line, fp ) != NULL) //to Fetch lines from file
{
int declaration=0,arithmetic=0,condition=0,forloop=0; //these flags
will decide which operation to be checked in a
//line.
char write_arithmetic;
char
read_arithmetic[50],write_declaration[50],read_declaration[50],read_for[50],write_for[
50];
max=0;
l++;
o=0;
i=0;
flag1=0;
if((line[i]=='i' && line[i+1]=='n' && line[i+2]=='t' && line[i+3]==' ') ||
(line[i]=='c' && line[i+1]=='h' && line[i+2]=='a' && line[i+3]=='r' && line[i+4]==' ') ||
(line[i]=='f' && line[i+1]=='l' && line[i+2]=='o' && line[i+3]=='a' && line[i+4]=='t'
&& line[i+5]==' ') || (line[i]=='d' && line[i+1]=='o' && line[i+2]=='u' &&
line[i+3]=='b' && line[i+4]=='l' && line[i+5]=='e' && line[i+6]==' '))
{
declaration=1;
int p;
if(line[0]=='i')
i=i+4;
if(line[0]=='c')
i=i+5;
if(line[0]=='d')
i=i+7;
if(line[0]=='f')
i=i+6;
p=i;
while(line[i]!=';')
{
if(line[i]=='=')
{
flag1++;
}
i++;
}
i=p;
if(flag1==0)
{
int x;
for(i=p;line[i]!=';';i++)
{
if(line[i]!=',' && line[i]!=' ')
{
x=critical_section(line[i],'w');
}
}
printf("line : %d\tshould go in block : %d\n",l,x);
}
else
{
i=p;
int count1=0,count2=0,count3=0;
while(flag1!=0)
{
while(line[i]!='=')
{
if(line[i]!=',' && line[i]!=' ')
{
write_declaration[count1]=line[i];
count1++;
max1[count2]=critical_section(line[i],'w');
count2++;
}
i++;
}
flag1--;
i++;
while(line[i]!=',' && line[i]!=';')
{
if(line[i]!='+' && line[i]!='-' && line[i]!='/' &&
line[i]!='*' && line[i]!='%' && line[i]!='0' && line[i]!='1' && line[i]!='2' &&
line[i]!='3' && line[i]!='4' && line[i]!='5' && line[i]!='6' && line[i]!='7' &&
line[i]!='8' && line[i]!='9')
{
read_declaration[count3]=line[i];
count3++;
max1[count2]=critical_section(line[i],'r');
count2++;
}
i++;
}
i++;
}
for(i=0;i<count2;i++)
{
if(max<max1[i])
{
max=max1[i];
}
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<count1;j++)
{
if(write_declaration[j]==list[o].name)
{
list[o].write=max;
}
}
o=o+1;
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<count3;j++)
{
if(read_declaration[j]==list[o].name)
{
list[o].read=max;
}
}
o=o+1;
}
printf("line : %d\tshould go in block : %d\n",l,max);
}
}
if(declaration==0)
{
if(line[i]=='f' && line[i+1]=='o' && line[i+2]=='r' && line[i+3]=='(')
{
n=0;
m=0;
int x=0;
i=i+4;
forloop=1;
while(line[i]!=';')
{
for(j=i;line[j]!='='; j++) //getting the variable which is
being modified
{
if(line[j]!=' ')
{
max1[m]=critical_section(line[j],'w');
m++;
write_for[x]=line[j];
x++;
// printf("write %c ",line[j]);
}
}
for(k=j+1;line[k]!=',' && line[k]!=';';k++)
{
if(line[k]!='+' && line[k]!=' ' && line[k]!='0' &&
line[k]!='1' && line[k]!='2' && line[k]!='3' && line[k]!='4' && line[k]!='5' &&
line[k]!='6' && line[k]!='7' && line[k]!='8' && line[k]!='9')
{
max1[m]=critical_section(line[k],'r');
m++;
read_for[n]=line[k];
n++;
// printf("read %c ",line[k]);
}
}
i=k++;
}
i++;
while(line[i]!=';')
{
if(line[i]!='<' && line[i]!='>' && line[i]!='=' &&
line[i]!='!' && line[i]!='+' && line[i]!='-' && line[i]!='/' && line[i]!='*' &&
line[i]!='%' && line[i]!='0' && line[i]!='1' && line[i]!='2' && line[i]!='3' &&
line[i]!='4' && line[i]!='5' && line[i]!='6' && line[i]!='7' && line[i]!='8' &&
line[i]!='9')
{
max1[m]=critical_section(line[i],'r');
m++;
read_for[n]=line[i];
n++;
// printf("read %c ",line[k]);
}
i++;
}
i++;
while(line[i]!=')')
{
for(j=i;line[j]!='='; j++) //getting the variable which is
being modified
{
if(line[j]!=' ')
{
max1[m]=critical_section(line[j],'w');
m++;
write_for[x]=line[j];
x++;
// printf("write %c ",line[j]);
}
}
for(k=j+1;line[k]!=',' && line[k]!=')';k++)
{
if(line[k]!='+' && line[k]!=' ' && line[k]!='0' &&
line[k]!='1' && line[k]!='2' && line[k]!='3' && line[k]!='4' && line[k]!='5' &&
line[k]!='6' && line[k]!='7' && line[k]!='8' && line[k]!='9')
{
max1[m]=critical_section(line[k],'r');
m++;
read_for[n]=line[k];
n++;
// printf("read %c ",line[k]);
}
}
if(line[k]==')')
break;
k++;
i=k;
}
for(i=0;i<m;i++)
{
if(max<max1[i])
{
max=max1[i];
}
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<x;j++)
{
if(write_for[j]==list[o].name)
{
list[o].write=max;
}
}
o=o+1;
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<n;j++)
{
if(read_for[j]==list[o].name)
{
list[o].read=max;
}
}
o=o+1;
}
printf("line : %d\tshould go in block : %d\n",l,max);
printf("for the next few instructions, till for loop ends, if output
comes out to be a block\nwhich is less than or equal to block%d, then consider the
output to be block%d",max,max+1);
}
}
if(declaration==0 && forloop==0)
{
i=0;
char read_condition[50];
int bracket_counter=0,counter,m=0,n=0;
if((line[i]=='i' && line[i+1]=='f' && line[i+2]=='(') || (line[i]=='w' &&
line[i+1]=='h' && line[i+2]=='i' && line[i+3]=='l' && line[i+4]=='e' &&
line[i+5]=='(')) //checking if and while
{
condition=1;
if(line[i]=='i')
counter=i+3;
if(line[i]=='w')
counter=i+6;
for(i=0;i<sizeof line;i++)
{
if(line[i]=='(')
{
bracket_counter++;
}
}
while(bracket_counter!=0)
{
if(line[counter]==')')
{
bracket_counter--;
}
if(line[counter]!='<' && line[counter]!='>' &&
line[counter]!='=' && line[counter]!='!' && line[counter]!='+' && line[counter]!='-'
&& line[counter]!='/' && line[counter]!='*' && line[counter]!='%' &&
line[counter]!='0' && line[counter]!='1' && line[counter]!='2' && line[counter]!='3'
&& line[counter]!='4' && line[counter]!='5' && line[counter]!='6' &&
line[counter]!='7' && line[counter]!='8' && line[counter]!='9')
{
max1[m]=critical_section(line[counter],'r');
m++;
read_condition[n]=line[counter];
n++;
// printf("read %c ",line[k]);
}
for(i=0;i<m;i++)
{
if(max<max1[i])
{
max=max1[i];
}
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<n;j++)
{
if(read_condition[j]==list[o].name)
{
list[o].read=max;
}
}
o=o+1;
}
counter++;
}
printf("line : %d\tshould go in block : %d\n",l,max);
printf("for the next few instructions, till this loop(if/while) ends,
if output comes out to be a block\nwhich is less than or equal to block%d, then consider
the output to be block%d",max,max+1);
}
}
if(declaration==0 && condition==0 && forloop==0)
{
for(i=0;line[i]!=';'; i++)
{
if(line[i]=='=') //checking arithmetic
operations
{
arithmetic=1;
n=0;
m=0;
for(j=0;line[j]!='='; j++) //getting the variable which is
being modified
{
if(line[j]!=' ')
{
max1[m]=critical_section(line[j],'w');
m++;
write_arithmetic=line[j];
// printf("write %c ",line[j]);
}
}
for(k=j+1;line[k]!=';';k++)
{
if(line[k]!='+' && line[k]!=' ' && line[k]!='0' &&
line[k]!='1' && line[k]!='2' && line[k]!='3' && line[k]!='4' && line[k]!='5' &&
line[k]!='6' && line[k]!='7' && line[k]!='8' && line[k]!='9')
{
max1[m]=critical_section(line[k],'r');
m++;
read_arithmetic[n]=line[k];
n++;
// printf("read %c ",line[k]);
}
}
break;
}
}
if(arithmetic==1)
{
for(o=0;o<m;o++)
{
if(max1[o]>max)
{
max=max1[o];
}
max1[o]=0;
}
o=0;
while(list[o].name!='\0')
{
if(write_arithmetic==list[o].name)
{
list[o].write=max;
}
o=o+1;
}
o=0;
while(list[o].name!='\0')
{
for(j=0;j<n;j++)
{
if(read_arithmetic[j]==list[o].name)
{
list[o].read=max;
}
}
o=o+1;
}
printf("line : %d\tshould go in block : %d\n",l,max);
}
}
for(q=0;q<128;q++)
{
line[q]=';';
}
}
fclose(fp);
}