public class MyThread extends Thread  {
	int i=0;
    @Override
    public void run () {
    	
    	//MidiChannel[] channels = null; 
	        while (!this.currentThread().isInterrupted()) {
	        	try{
	        		
	        		
	        	}catch (Exception e1) {
	    			e1.printStackTrace();
	    		}
	        	if(Thread.currentThread().interrupted()){
	        		//channels[1].allNotesOff();
	        		System.out.println("zabity");
	        		break;
	        		
	        	}
	        	
	        	
	        }
    }
}