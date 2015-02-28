#include<stdio.h>
#include<stdlib.h>
#include<math.h>

double entropyDataset(int **training, int size2, int numAttr)
{
	printf("%d",size2);
	int i,j;
	int classCount[26]={0};
	double entropyData=0.0;
	for(i=0;i<size2;i++)
	classCount[training[i][0]-65]++;
	for(i=0;i<26;i++)
	{
		if(classCount[i]!=0)
		entropyData+=-(((double)classCount[i]/size2)*(log2((double)classCount[i]/size2)));
	}	
	return(entropyData);
}

int bestAttribute(int **training, int size1, int numAttr)
{
	int i,j,k;
	double entropyData = entropyDataset(training,size1,numAttr);
	printf("%lf",entropyData);
	int attributeCount[numAttr-1][16];
	for(i=0;i<numAttr-1;i++)
	for(j=0;j<16;j++)
	attributeCount[i][j]=0;
	double maxIG=0.0,informationGain[16]={0.0};
	int root;
	for(i=0;i<size1;i++)
	{
		for(j=1;j<numAttr;j++)
		{
			attributeCount[j-1][training[i][j]]++;
		}
	}
	
	for(i=1;i<numAttr;i++)
	{
		for(j=0;j<16;j++)
		{
			double temp_entropy=0.0;
			int tempClassCount[26]={0};
			for(k=0;k<size1;k++)
			{
				if(training[k][i]==j)
				{
					tempClassCount[training[k][0]-65]++;
				}
			}
			for(k=0;k<26;k++)
			{
				if(tempClassCount[k]!=0 && attributeCount!=0)					
				temp_entropy+=-(((double)tempClassCount[k]/attributeCount[i-1][j])*(log2((double)tempClassCount[k]/attributeCount[i-1][j])));
			}			
			informationGain[i-1]+=(((double)attributeCount[i-1][j]/size1)*(temp_entropy));			
		}
		informationGain[i-1]=entropyData-informationGain[i-1];
		printf("%lf\n",informationGain[i-1]);
		if(informationGain[i-1]>maxIG)
		{
			maxIG=informationGain[i-1];
			root=i;	
		}
	}
	return(root);
}

void buildTree(int **training,int size, int numAttr, int level)
{
	if(size!=0 && numAttr!=1)
	{
		int i,j,k,l=0,m=0,n;	
		int bestAttr = bestAttribute(training,size,numAttr);
		int count[16]={0};	
		printf("Level -> %d : %d \n",level,training[size][bestAttr]);
		for(j=0;j<size;j++)
		count[training[j][bestAttr]]++;		
		for(i=0;i<16;i++)
		{
			if(count[i]!=0)
			{
				int **newtraining=(int **)malloc((count[i]+1)*sizeof(int *));
		      		for(n=0;n<count[i]+1;n++)
				newtraining[n]=(int *)malloc((numAttr-1)*sizeof(int));
	
				for(j=0;j<size;j++)
				{
					if(training[j][bestAttr]==i)
					{
						for(k=0;k<numAttr;k++)
						{
							if(k!=bestAttr)
							{
								newtraining[l][m]=training[j][k];
								m++;
							}
						}
						l++;
						m=0;
					}	
				}
				m=0;
				for(k=0;k<numAttr;k++)
				{
					if(k!=bestAttr)
					{
						newtraining[count[i]][m]=training[size][k];
						m++;
					}
				}
				buildTree(newtraining,count[i],(numAttr-1),(level+1));
			}
		}
	}		
}
int main()
{
	FILE *fp1;
	int n,i=0,j=0,k=0,l=0,split,temp,classCount[26]={0},attributeCount[16][16]={0};
	double entropyDataset=0.0,informationGain[16]={0.0};
	char temp_string[2]={' '},line[50]={0};	
	
	printf("1. 70-30 percent split\n2. 80-20 percent split\n3. Leave one partition out method\n");
	printf("Enter Your choice:\n");
	scanf("%d",&n);

	fp1 = fopen("letter.data","r");
	
	if(n==1)
	split = 70*200;
	else
	split = 80*200;

	int **training=(int **)malloc((split+1)*sizeof(int *));
      	for(i=0;i<split+1;i++)
	training[i]=(int *)malloc(17*sizeof(int));
	
	int **testing=(int **)malloc(((20000-split+1))*sizeof(int *));
      	for(i=0;i<(20000-split+1);i++)
	testing[i]=(int *)malloc(17*sizeof(int));
	
	i=0;
	while(fgets(line,sizeof(line),fp1)!=NULL)
	{
		int index1=0,index2=0,index3=0;
		if(i<split)
		{
			while(line[index1]!='\n')
			{
				if(line[index1]!=',')
				{
					temp_string[index2]=line[index1];
					index2++;
					index1++;
					if(line[index1]=='\n')
					{
						temp = atoi(temp_string);
						training[i][index3]=temp;
						temp_string[0]=temp_string[1]=' ';
					}				
				}
				else
				{
					if(index3!=0)
					temp = atoi(temp_string);
					else
					temp = (int)temp_string[0];					
					training[i][index3]=temp;
					index1++;
					index2=0;
					index3++;
					temp_string[0]=temp_string[1]=' ';			
				}
			}
		}
		else
		{
			while(line[index1]!='\n')
			{
				if(line[index1]!=',')
				{
					temp_string[index2]=line[index1];
					index2++;
					index1++;
					if(line[index1]=='\n')
					{
						temp = atoi(temp_string);
						testing[i-split][index3]=temp;
						temp_string[0]=temp_string[1]=' ';
					}				
				}
				else
				{
					if(index3!=0)
					temp = atoi(temp_string);
					else
					temp = (int)temp_string[0];
					testing[i-split][index3]=temp;
					index1++;
					index2=0;
					index3++;	
					temp_string[0]=temp_string[1]=' ';
				}
			}
		}
		i++;
	}
	for(i=0;i<17;i++)
	{
		training[split][i]=i;
		testing[20000-split][i]=i;	
	}
	buildTree(training,split,17,0);
}
