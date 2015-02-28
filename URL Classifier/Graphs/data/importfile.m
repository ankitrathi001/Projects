function importfile(fileToRead1)
rawData1 = importdata(fileToRead1);
%rawData1(:,1)
%rawData1(:,2)
hold on
plot(rawData1(:,1),rawData1(:,2));
xlabel('Number of URLs');
ylabel('Number of non-zero features');
hold off
end
