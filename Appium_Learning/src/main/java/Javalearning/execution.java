package Javalearning;
	// Java code to illustrate order of 
	// execution of constructors, static 
	// and initialization blocks 
	class execution { 
	  static int i=5;
	  int j=0;
	    execution(int x) 
	    { 
	    	System.out.println("Parameter constructor");
	    } 
	  
	    execution() 
	    { 
	    	System.out.println("No argument constructor");
	    } 
	  
	    static
	    { 
	        System.out.println(i); 
	        i=7;
	    } 
	    
	    { 
	        System.out.println(j); 
	        j=2;
	    }
	  public void instancemethod() {
		  System.out.println(j);
		  j=1;
	  }
	  static void staticMethod() {
	        System.out.println(i);
	        i=8;
	    }
	  
	    public static void main(String[] args) 
	    { 
	       execution e = new execution(); 
	       e.instancemethod();
	        staticMethod();
	      execution e1 = new execution(8); 
	        System.out.println(e.j);
	        System.out.println(e.i);
	    } 

	} 
	

