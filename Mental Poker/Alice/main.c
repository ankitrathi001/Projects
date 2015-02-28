#include <string.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define SENDER_PORT 12345								/* Port number */
#define card_length 52

unsigned GCD(unsigned, unsigned);
long long int generateRandomnum(long long int, long long int);
long long int modInverse(long long int, long long int);
long long int modular_pow(long long int, long long int, long long int);
void shuffleIndices();
int indices[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51};
void fatal(char *string)								/* function to print error messages */
{
    printf("%s\n",string);
    exit(1);
}

int main(int argc, char *argv[])
{
    struct sockaddr_in sender_addr;

    int sockfd,i;
    int rcv_num;
    long long int sum_bob = 0;
    long long int product_bob = 1;
    long long int sum_Alice = 0;
    long long int product_Alice = 1;
    int buf[53];
    int ack[5];
    FILE *fp;

    if( (sockfd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) == -1)			/* open socket and connect */
    {
        perror("socket error");
        exit(1);
    }

    sender_addr.sin_family = AF_INET;
    sender_addr.sin_port = htons(SENDER_PORT);
    sender_addr.sin_addr.s_addr = inet_addr("127.0.0.1");
    memset(sender_addr.sin_zero, '\0', sizeof(sender_addr.sin_zero));

    if ((connect(sockfd,(struct sockaddr *)&sender_addr,sizeof(sender_addr))) ==-1)
    {
        fatal("connect error");
    }

    printf("Connection to Bob established\n");					/* connection established */

    rcv_num = recv(sockfd,&buf,sizeof(buf),0);
    srand (time(NULL));
    long long int n=buf[52];
    printf("Shared Value of 'n': %lld\n",n);
    long long int z = n-1;
    long long int public_key =generateRandomnum(2,z-1);
    while(GCD(public_key,z)!=1)
       public_key =generateRandomnum(2,z-1);
    long long int pr_key = modInverse(public_key,z);

    //encrypting Alice's cards withalice public key
    shuffleIndices();
    fp = fopen("SelectedCards.txt", "w");
    fprintf(fp, "Indices of Alice's' cards\n");
    for(i=0;i<5;i++){
        fprintf(fp, "%d\n", indices[i]);
    }
    fprintf(fp, "Indices of Bob's' cards\n");
    for(i=5;i<10;i++){
        fprintf(fp, "%d\n", indices[i]);
    }
    printf("Indices of selected cards written in SelectedCards.txt file\n");

    fclose(fp);

    int myCards[5] = {
        modular_pow(buf[indices[0]],public_key,n),
        modular_pow(buf[indices[1]],public_key,n),
        modular_pow(buf[indices[2]],public_key,n),
        modular_pow(buf[indices[3]],public_key,n),
        modular_pow(buf[indices[4]],public_key,n)
    };

    //Selecting Bob Cards.
    int bobCards[5] = {buf[indices[5]], buf[indices[6]], buf[indices[7]], buf[indices[8]], buf[indices[9]]};

    if(rcv_num!=0)
    {
        send(sockfd,&myCards,sizeof(myCards),0);
        send(sockfd,&bobCards,sizeof(bobCards),0);
    }
    else
        fatal("Receive error");
    int myEncryptedCardsFromBob[5];
    rcv_num = recv(sockfd,&myEncryptedCardsFromBob,sizeof(myEncryptedCardsFromBob),0);
    printf("Alice's Cards:\n");
    if(rcv_num!=0){
        for(i=0;i<5;i++){
            long long int x = modular_pow(myEncryptedCardsFromBob[i],pr_key,n);
            printf("%lld\n",x);
            sum_Alice+=x;
            product_Alice *=x;
        }
    }
    else
        fatal("Receive error");
    printf("Sending privatekey to Bob for verification\n");
    long long int my_Pr_Key[1] = {pr_key};
    send(sockfd,&my_Pr_Key,sizeof(my_Pr_Key),0);
    long long int Bob_Pr_Key[1];
    recv(sockfd,&Bob_Pr_Key,sizeof(Bob_Pr_Key),0);
    printf("Decrypting Bob's cards with his private key %lld\n",Bob_Pr_Key[0]);
    for(i=0;i<5;i++){
        long long int x = modular_pow(bobCards[i],Bob_Pr_Key[0],n);
        printf("%lld\n",x);
        sum_bob+=x;
        product_bob *=x;
    }
    if(sum_bob>sum_Alice)
        printf("Bob is the winner!\n");
    else if(sum_bob<sum_Alice)
        printf("Alice is the winner!\n");
    else if(product_bob>product_Alice)
        printf("Bob is the winner!\n");
    else
        printf("Alice is the winner!\n");
    printf("\nClose socket and exit\n");
    close(sockfd);
    exit(0);
}
unsigned GCD(unsigned u, unsigned v) {
    while ( v != 0) {
        unsigned r = u % v;
        u = v;
        v = r;
    }
    return u;
}
long long int generateRandomnum(long long int a, long long int b)
{

    return ((rand()%(b-a))+a);
}
long long int modInverse(long long int a, long long int m)
{
    int x;
    for(x = m; x <2* m; x++) {
        if((a*x) % m == 1)
            return x;
    }
}
long long int modular_pow(long long int base, long long int exponent, long long int modulus)
{
    long long int result = 1;
    while (exponent > 0)
    {
        if (exponent % 2 == 1)
            result = (result * base) % modulus;
        exponent = exponent >> 1;
        base = (base * base) % modulus;
    }
    return result;
}
void shuffleIndices()
{
    int i;
    srand (time(NULL));
    for(i=0;i<10;i++)
    {

        int j=rand()%card_length;
        int temp= indices[i];
        indices[i]=indices[j];
        indices[j]=temp;
    }
}
