

import java.util.Random;
import java.util.Scanner;

public class qlearning_ex1
{
    private static final int Q_SIZE = 18;
    private static final double GAMMA = 0.9;
    private static final int ITERATIONS = 10;
    private static final int INITIAL_STATES[] = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

   

    private static int q[][] = new int[Q_SIZE][Q_SIZE];
    private static int currentState = 0;
    
    private static final int R[][] = new int[18][18] ;
    
    public qlearning_ex1(int[][] R)
    {
    	int i,j;
    	for(i=0; i<18;i++)
    		for(j=0;j<18;j++)
    		{
    			{
    				qlearning_ex1.R[i][j] = R[i][j];
    				
    			}
    			
    		}
    	
    	for(i=0;i<18;i++) {
        	for(j=0;j<18;j++)
        	{
        		 System.out.print( ", "+R[i][j]);
        	}
        	System.out.println();
        }
    
    }
    
    
    private static void train()
    {
        initialize();

        // Perform training, starting at all initial states.
        for(int j = 0; j < ITERATIONS; j++)
        {
            for(int i = 0; i < 18; i++)
            {
                episode(INITIAL_STATES[i]);
            } // i
        } // j

        System.out.println("Q Matrix values:");
        for(int i = 0; i < Q_SIZE; i++)
        {
            for(int j = 0; j < Q_SIZE; j++)
            {
                System.out.print(q[i][j] + ",\t");
            } // j
            System.out.print("\n");
        } // i
        System.out.print("\n");

        return;
    }
    
    private static void test()
    {
        // Perform tests, starting at all initial states.
        System.out.println("Shortest routes from initial states:");
        for(int i = 0; i < 18; i++)
        {
            currentState = INITIAL_STATES[i];
            int newState = 0;
            do
            {
                newState = maximum(currentState, true);
                System.out.print(currentState + ", ");
                currentState = newState;
            }while(currentState < 17);
            System.out.print("17\n");
        }

        return;
    }
    
    private static void episode(final int initialState)
    {
        currentState = initialState;

        // Travel from state to state until goal state is reached.
        do
        {
            chooseAnAction();
        }while(currentState == 17);

        // When currentState = 5, Run through the set once more for convergence.
        for(int i = 0; i < 18; i++)
        {
            chooseAnAction();
        }
        return;
    }
    
    private static void chooseAnAction()
    {
        int possibleAction = 0;

        // Randomly choose a possible action connected to the current state.
        possibleAction = getRandomAction(Q_SIZE);

       // if(R[currentState][possibleAction] >= 0){
            q[currentState][possibleAction] = reward(possibleAction);
            currentState = possibleAction;
     //   }
        return;
    }
    
    private static int getRandomAction(final int upperBound)
    {
        int action = 0;
        boolean choiceIsValid = false;

        // Randomly choose a possible action connected to the current state.
        while(choiceIsValid == false)
        {
            // Get a random value between 0(inclusive) and 6(exclusive).
            action = new Random().nextInt(upperBound);
            if(R[currentState][action] > -1){
                choiceIsValid = true;
            }
        }

        return action;
    }
    
    private static void initialize()
    {
        for(int i = 0; i < Q_SIZE; i++)
        {
            for(int j = 0; j < Q_SIZE; j++)
            {
                q[i][j] = 0;
            } // j
        } // i
        return;
    }
    
    private static int maximum(final int State, final boolean ReturnIndexOnly)
    {
        // If ReturnIndexOnly = True, the Q matrix index is returned.
        // If ReturnIndexOnly = False, the Q matrix value is returned.
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            for(int i = 0; i < Q_SIZE; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    if(q[State][i] > q[State][winner]){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }

            if(foundNewWinner == false){
                done = true;
            }
        }

        if(ReturnIndexOnly == true){
            return winner;
        }else{
            return q[State][winner];
        }
    }
    
    private static int reward(final int Action)
    {
        return (int)(R[currentState][Action] + (GAMMA * maximum(Action, false)));
    }
    
    public static void main(String[] args)
    {
    	
    	Scanner in=new Scanner (System.in);
        int R[][]=new int[18][18];
        int i,j;
        
        for (i=0;i<18;i++) {
        	for(j=0;j<18;j++)
        	{
        		 R[i][j]=-1;
        		
        	
        	}
        } 
        
        R[0][4]=0;R[1][3]=0;R[1][5]=1;R[2][3]=0;
        R[3][1]=2;R[3][2]=0;R[3][4]=1;R[4][0]=0;
        R[4][3]=0;R[4][5]=2;R[5][1]=0;R[5][4]=0;
        R[5][6]=0;R[5][7]=2;R[6][5]=0;R[6][8]=1;
        R[7][5]=0;R[7][9]=1;R[8][6]=0;R[9][7]=0;
        R[9][10]=0;R[10][9]=0;R[10][11]=1;R[10][12]=1;
        R[11][10]=0;R[11][14]=1;R[12][10]=0;R[12][13]=5;
        R[13][12]=0;R[13][16]=0;R[13][17]=100;R[14][11]=0;
        R[14][15]=1;R[15][14]=0;R[15][16]=1;R[16][13]=1;R[16][15]=0;
        R[17][13]=0;R[17][17]=100;
        

        
        
           
            
                qlearning_ex1 hello = new qlearning_ex1(R);
               
                
        train();
        test();
        return;
    }

}