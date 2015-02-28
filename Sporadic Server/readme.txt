<=========================================================================================================>
|													  |
|		 _______________________________________________________________			  |
|		| 								|			  |
|		|***************************************************************|			  |
|		|******************    Real Time Systems    ********************|			  |	
|		|*******************    Sporadic Server     ********************|			  |
|		|***************************************************************|			  |
|		|***************************************************************|			  |
|		|****************    Anshul Jain(y09uc027)    ******************|			  |
|		|***************************************************************|			  |
|		|_______________________________________________________________|			  |
|													  |
|													  |
<=========================================================================================================>
|													  |
|													  |
|Steps for running the code:										  |
|													  |
|1. Compile the c code (sporadic.c) with gcc sporadic.c -lm.						  |
|2. Run the program using ./a.out.									  |		
|3. Enter you choice (1 for Fixed priority or 2 for Dynamic Priority).					  |
|4. Enter number of periodic tasks.									  |
|5. Enter number of Aperiodic tasks.									  |
|6. Enter Timeperiod and Computation time for all the periodic tasks.					  |
|7. Enter Computation time and Arrival time for all the aperiodic tasks.				  |
|8. Enter timeperiod and computation budget of the sporadic server.					  |
|													  |
|													  |
<=========================================================================================================>
<=========================================================================================================>
|													  |
|													  |
|After the program execution is complete, 2 image files are generated namely :				  |
|													  |
|a) graph.png -> Sigma function										  |
|	>Description is mentioned in the image file only.						  |
|b) scheduling.ppm(can be viewed only in LINUX) -> The actual schedule of the all the tasks.		  |
|	>The bottom most row corresponds to the schedule of aperiodic tasks.				  |
|	>Rest of the rows corresponds to periodic tasks task1 at the top and the rest below it in order.  |
|	>Red line corresponds to Deadline(Timeperiod) of periodic tasks.				  |
|	>Green line corresponds to arrival of aperiodic tasks.						  |
|	>Blue  line corresponds to completion of aperiodic tasks.                                         |
|													  |
|Apart from these files, the output on the terminal explains the sigma function of the taskset.		  |
|Another file 'gnuPlotFile'is generated which is used to plot the sigma function.			  |
|													  |
|													  |
<=========================================================================================================>
			
			
					-----------xxx-----------