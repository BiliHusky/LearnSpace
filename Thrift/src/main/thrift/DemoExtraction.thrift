namespace java com.yjw.test.extract

service DemoExtraction{
	string job(1:string querySets, 2:string header, 3:string queueName);
}