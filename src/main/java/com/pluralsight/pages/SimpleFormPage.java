package com.pluralsight.pages;

public class SimpleFormPage {

   //Interconnected classes
    private Acts act;
    private Verifications verify;
    private ExamplesController getExamplesController;
    
    private SimpleFormPage() {
        // hide it
    }
    
    public Acts act() {  //method that returns Act class object
        return act;
    }

    public Verifications verify() { //method that returns Verifications class object
        return verify;
    }
    
    public ExamplesController getExamplesController() {  //method that returns Act class object
        return getExamplesController;
    }

    private SimpleFormPage(Acts act, Verifications verify ,ExamplesController getExamplesController) {//extra constructor that accepts Act and Verifications objects
        this.act = act; 
        this.verify = verify; 
        this.getExamplesController = getExamplesController;
    }
   
    public static SimpleFormPage getSimpleFormPage() {//static factory method which initialize all method objects
        return new SimpleFormPage(new Acts(), // creates and adds the methods from this classes returns the class object
                                  new Verifications(),
                                  new ExamplesController()); // returns the class object
    }

    
    
    

}
