#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>

#

void error(const char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[])
{
    int sockfd1,sockfd2, newsockfd1,newsockfd2, portno1,portno2;
    char name[128], location[128];
    char data[10][128];
    int option;
    socklen_t clilen1,clilen2;
    char buffer[256];
    struct sockaddr_in serv_addr1, cli_addr1,serv_addr2, cli_addr2;
    int n,flag=0;
    if (argc < 2) {
        fprintf(stderr,"ERROR, no port provided\n");
        exit(1);
    }
     

       
    sockfd1 = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd1 < 0) 
        error("ERROR opening socket");
    bzero((char *) &serv_addr1, sizeof(serv_addr1));
    portno1 = atoi(argv[1]);
    serv_addr1.sin_family = AF_INET;
    serv_addr1.sin_addr.s_addr = INADDR_ANY;
    serv_addr1.sin_port = htons(portno1);
    if (bind(sockfd1, (struct sockaddr *) &serv_addr1, sizeof(serv_addr1)) < 0) 
        error("ERROR on binding");
    listen(sockfd1,5);
    clilen1 = sizeof(cli_addr1);
    // newsockfd1 = accept(sockfd1, (struct sockaddr *) &cli_addr1,  &clilen1);
    // if (newsockfd1 < 0) error("ERROR on accept");
    //     printf("connected\n");


    while(1)
    {
        printf("waiting for connection...\n");
        newsockfd1 = accept(sockfd1, (struct sockaddr *) &cli_addr1,  &clilen1);
        if (newsockfd1 < 0) error("ERROR on accept");
            printf("connected\n");
        
        //listen(sockfd1,5);
        //clilen1 = sizeof(cli_addr1);
        // newsockfd2 = accept(sockfd1, (struct sockaddr *) &cli_addr1,  &clilen1);
        // if (newsockfd1 < 0) error("ERROR on accept");
        // flag =1;
        //printf("%d\n",newsockfd1);

        bzero(buffer,256);
        bzero(name,127);
        bzero(location,127);
        n = read(newsockfd1,buffer,255);
        if (n < 0) error("ERROR reading from socket");

        sscanf(buffer,"%d",&option);
        switch(option[0]){
            case 0:
            //user retrieve info
                char buf2[1024];
                bzero(buf2,1023);
                ssprintf(buf2,"%s %s %s %s %s %s",name[0],location[0],name[1],location[1],name[2],location[2]);
                write(newsockfd1,buf2,strlen(buf2));
                printf("written!\n");
                break;
            case 1:
            //user upload info
                sscanf(buffer,"%d %s %s",&option,name,location);
                if(name[0] == 'X')  strcpy(name[0], location);
                if(name[0] == 'B')  strcpy(name[1], location);
                if(name[0] == 'R')  strcpy(name[2], location);
                printf("saved!\n");
                break;
        }


        // if( strcmp(buffer,"end") == 0)
        // {
        //     printf("connet end\n");
        //     close(newsockfd2);
        //     flag = 0;
        //     break;
        // }
        printf("receive message: %s\n",buffer);
        // if(n>2) n = write(newsockfd1,buffer,255);
        // if (n < 0) error("ERROR writing to socket");
        n=0;

    } 
         
    close(newsockfd1);
    close(sockfd1);
    close(newsockfd2);
    close(sockfd2);
    return 0; 
}