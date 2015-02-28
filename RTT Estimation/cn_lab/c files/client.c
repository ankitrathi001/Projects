#include <string.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>

#define SENDER_PORT 12345								/* Port number */

void fatal(char *string)								/* function to print error messages */
{
	printf("%s\n",string);
	exit(1);
}

int main(int argc, char *argv[]) 
{
	struct sockaddr_in sender_addr;
	struct timeval receive,sendack;
 	
	int sockfd;
 	int rcv_num,loop_count,i;
 	
	char buf[1200];									/* buffer of 1200 bytes to accept the transmitted packets */
 	double t3,t4;
	
	if(argc!=2)									/* Command line arguments */
    	{
		fatal("Usage: ./a.out <Server_IP_Address>");				/* eg: ./a.out 172.22.15.145 */
	}	

 	if( (sockfd = socket(PF_INET, SOCK_STREAM, IPPROTO_TCP)) == -1)			/* open socket and connect */
	{
	  	perror("socket error"); 
	  	exit(1);
	}

 	sender_addr.sin_family = AF_INET;
 	sender_addr.sin_port = htons(SENDER_PORT);
 	sender_addr.sin_addr.s_addr = inet_addr(argv[1]);
 	memset(sender_addr.sin_zero, '\0', sizeof(sender_addr.sin_zero));
	 
 	if ((connect(sockfd,(struct sockaddr *)&sender_addr,sizeof(sender_addr))) ==-1)
	{
		fatal("connect error"); 
 	}

 	printf("Connection to sender established\n");					/* connection established */
 	printf("Receive 1500 packets of 1200 byte and send them back\n");		/* reads 1500 packets and sends them back as ack packets */
 	
	for(i=0;i<1500;i++)
	{
		rcv_num = recv(sockfd,&buf,sizeof(buf),0);
		if(gettimeofday(&receive,NULL)) 
		{
		   fatal("time failed\n");
  		}
  		
		if(rcv_num!=0)								/* if some packets have been received */			 
		{
			if(gettimeofday(&sendack,NULL)) 
   			fatal("time failed\n");
  			
			if(gettimeofday(&sendack,NULL)) 
			fatal("time failed\n");
  			
   			send(sockfd,&buf,sizeof(buf),0);				/* sending back the acknowledgements */
		}
  		else
		fatal("Receive error");
  		
		t3=receive.tv_sec+(receive.tv_usec/1000000.0);				/* time at which packet is received from the server */
        	t4=sendack.tv_sec+(sendack.tv_usec/1000000.0);				/* time at which ack is sent back to the server */
		
		printf("\nSegments Received at, T3 =  %f",t3);				
		printf("\nAcknowledgement sent at, T4 = %f",t4);		
		printf("\nProcess Time = %f ms\n",(t4-t3)*1000.0);
 	}
 
	printf("\nClose socket and exit\n");
	close(sockfd);
	exit(0);
}
