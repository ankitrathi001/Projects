function comparision_jacob(fileToRead1,fileToRead2,fileToRead3,fileToRead4)
rawData1 = importdata(fileToRead1);
rawData2 = importdata(fileToRead2);
rawData3 = importdata(fileToRead3);
rawData4 = importdata(fileToRead4);
hold on
plot(rawData1(:,4),'color','b')
plot(rawData2(:,4),'color','r')
plot(rawData3(:,4),'color','g')
plot(rawData4(:,4),'color','black')
hold off

end

