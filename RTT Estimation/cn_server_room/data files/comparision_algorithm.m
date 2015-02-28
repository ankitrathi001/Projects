function comparision_algorithm(fileToRead1,fileToRead2,fileToRead3)
rawData1 = importdata(fileToRead1);
rawData2 = importdata(fileToRead2);
rawData3 = importdata(fileToRead3);
hold on
plot(rawData1(:,4)-rawData1(:,2),'color','b')
plot(rawData2(:,4)-rawData2(:,2),'color','r')
plot(rawData3(:,4)-rawData3(:,2),'color','g')
hold off
end

