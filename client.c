#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <arpa/inet.h>
#include <wiringPi.h> 

char name[3][50];
char place[3][50];

int socket_client(char *ip, int port)
{
    int sockfd = 0;
    char buffer[1024];
    struct sockaddr_in serv_addr; 

    memset(buffer, '\0',sizeof(buffer));
    if((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Error : Could not create socket \n");
        return 1;
    } 
    memset(&serv_addr, '0', sizeof(serv_addr)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(port); 

    if(inet_pton(AF_INET, ip, &serv_addr.sin_addr)<=0)
    {
        printf("\n inet_pton error occured\n");
        return 1;
    } 
    if(connect(sockfd, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
       printf("\n Error : Connect Failed \n");
       return 1;
    } 
    sprintf(buffer, "0");
    write(sockfd, buffer, sizeof(buffer));
    if (read(sockfd, buffer, sizeof(buffer)) < 0)
    {
        printf("\n Error : Read Failed \n");
        return 1;
    } 
    printf("buffer : [%s]\n\n", buffer);

    sscanf(buffer, "%s %s %s %s %s %s", name[0], place[0], name[1], place[1], name[2], place[2]);    

    sleep(1);
    close(sockfd);
    
    return 0;
}

int main(int argc, char *argv[])
{
    int port = atoi(argv[2]);
    if (wiringPiSetup () == -1 ) exit (1);
    
    int i;
    int pin[9] = {7, 0, 2, 1, 4, 5, 6, 10, 11};
    
    for (i = 0; i < 9; i++)
    {
        pinMode(pin[i], OUTPUT);
    }

    while (1)
    {
        socket_client(argv[1], port);
        for (i = 0; i < 3; i++)
        {
            if (place[i][0] == 'c') // csie_basement.
            {
                switch (i)
                {
                    case 0:
                        digitalWrite(7, 1);
                        digitalWrite(0, 0);
                        digitalWrite(2, 0);
                        break;
                    case 1:
                        digitalWrite(1, 1);
                        digitalWrite(4, 0);
                        digitalWrite(5, 0);
                        break;
                    case 2:
                        digitalWrite(6, 1);
                        digitalWrite(10, 0);
                        digitalWrite(11, 0);
                        break;
                }
            }
            else if (place[i][0] == 'd')    // drunkmoonlake.
            {
                switch (i)
                {
                    case 0:
                        digitalWrite(0, 1);
                        digitalWrite(7, 0);
                        digitalWrite(2, 0);
                        break;
                    case 1:
                        digitalWrite(4, 1);
                        digitalWrite(1, 0);
                        digitalWrite(5, 0);
                        break;
                    case 2:
                        digitalWrite(10, 1);
                        digitalWrite(6, 0);
                        digitalWrite(11, 0);
                        break;
                }
            }
            else if (place[i][0] == 's')    // somewhere_else.
            {
                switch(i)
                {
                    case 0:
                        digitalWrite(2, 1);
                        digitalWrite(7, 0);
                        digitalWrite(0, 0);
                        break;
                    case 1:
                        digitalWrite(5, 1);
                        digitalWrite(1, 0);
                        digitalWrite(4, 0);
                        break;
                    case 2:
                        digitalWrite(11, 1);
                        digitalWrite(6, 0);
                        digitalWrite(10, 0);
                        break;
                }
            }    
            else    // offline.
            {
                switch(i)
                {
                    case 0:
                        digitalWrite(7, 0);
                        digitalWrite(0, 0);
                        digitalWrite(2, 0);
                        break;
                    case 1:
                        digitalWrite(1, 0);
                        digitalWrite(4, 0);
                        digitalWrite(5, 0);
                        break;
                    case 2:
                        digitalWrite(6, 0);
                        digitalWrite(10, 0);
                        digitalWrite(11, 0);
                        break;
                }
            }
        }
        sleep(1);
    }
    return 0;
}
