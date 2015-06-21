#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h> 
#include <sys/socket.h>
#include <netinet/in.h>

void error(const char *msg)
{
    perror(msg);
    exit(1);
}

int main(int argc, char *argv[])
{
    int sockfd1,sockfd2, newsockfd1,newsockfd2, portno1,portno2;
    char name[128], location[128];
    char l_data[10][128];
    char n_data[10][128];
    char buf2[1024];
    char offline[] = "(offline)";
    char none[] = "(none)";
    int option;
    socklen_t clilen1,clilen2;
    char buffer[256];
    struct sockaddr_in serv_addr1, cli_addr1,serv_addr2, cli_addr2;
    int n,flag=0,i;
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
    for(i = 0;i <3;i++){
        bzero(n_data[i],127);
        bzero(l_data[i],127);
        strcpy(n_data[i],offline);
        strcpy(l_data[i],none);
    }


    while(1)
    {
        printf("waiting for connection...\n");
        newsockfd1 = accept(sockfd1, (struct sockaddr *) &cli_addr1,  &clilen1);
        if (newsockfd1 < 0) error("ERROR on accept");
            printf("connected\n");
        
        bzero(buffer,256);
        bzero(name,127);
        bzero(location,127);
        option = -1;
        n = read(newsockfd1,buffer,255);
        printf("read: %s\n",buffer);
        if (n < 0) error("ERROR reading from socket");

        sscanf(buffer,"%d",&option);
        printf("received option %d\n",option);
        switch(option){
            case 0:
            //user retrieve info
                bzero(buf2,1023);
                for(i = 0;i <3;i++){
                    strcat(buf2,n_data[i]);
                    strcat(buf2," ");
                    strcat(buf2,l_data[i]);
                    strcat(buf2," ");
                }
                write(newsockfd1,buf2,strlen(buf2));
                printf("send %s\n",buf2);
                break;
            case 1:
            //user upload info
                sscanf(buffer,"%d %s %s",&option,name,location);
                if(name[0] == 'X'){
                    bzero(n_data[0],127);
                    bzero(l_data[0],127);
                    strcpy(n_data[0], name);
                    strcpy(l_data[0], location);
                }
                if(name[0] == 'B'){
                    bzero(n_data[1],127);
                    bzero(l_data[1],127);
                    strcpy(n_data[1], name);
                    strcpy(l_data[1], location);
                }
                if(name[0] == 'R'){
                    bzero(n_data[2],127);
                    bzero(l_data[2],127);
                    strcpy(n_data[2], name);
                    strcpy(l_data[2], location);
                }


                break;
        }

        n=0;

    } 
         
    close(newsockfd1);
    close(sockfd1);
    close(newsockfd2);
    close(sockfd2);
    return 0; 
}