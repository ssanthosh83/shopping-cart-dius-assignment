##DiUS - Shopping cart assignment

This Shopping cart application is developed using Java. 

###About the Application Environment
- Language      : Java8
- Build         : Maven
- UnitTesting   : Junit5
- IDE           : Intellij IDEA
- Test Coverage : under src/test/resource/coverage folder

###To execute the application:
- Import the project as a Maven Project 
- Run the Junit Tests under the folder test/java/org/santhosh/computerstore/

Solution:
This is an object oriented solution to the problem:

1. Checkout Class
    This represents the main class of the application (Check out in the POS counter)

2. Offers 
    - This package contains algorithms for all offers. 
    - Strategy Design Pattern is used here. A new Offer algorithm can be easily added by implementing the Offers interface
    - There are 3 algorithms implemented for 3 different offers:
         1. AppleTv3For2Deal -- This implements logic for giving 3 AppleTVs for the price of 2.
         2. FreeVGAAdapterForMacBookPro -- This implements logic for giving VGA Adapter free for all MacBook Pros purchased.
         3. SuperIPadBulkDiscountFor4 -- This implements logic for giving bulk discounts for buying more than or equal to 4 IPADs

3. models
     - Product : The Product Model is defined here.
     - Sku     : Enum for all products. In case, if we need to change anything related to the product. This is the only place to change.

Testing Approach followed : TDD (Test Driven Development)

