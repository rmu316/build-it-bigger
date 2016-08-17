# build-it-bigger

# About
Android project for Lesson 4: Build it Bigger in Android Nanodegree. Joke-telling app with free/paid version, java &amp; android library for fetching jokes and displaying data, and test class for running Android tests 

#Usage

1. Build the App
To build the app, click on the "Gradle" pane on the right side of the Android Studio IDE. Then, under :app, Tasks, install, click on either installFreeDebug or installPaidDebug, which will install either the free or paid version of the app, respectively.

2. Setup the GCE server
This server will retreive jokes using an AsyncTask from the java library. To set this server up, modify the IP address within EndpointsAsyncTask (on line 50) to be your computer's IP address (you can find that by typing either ifconfig or ipconfig depending on if you have Unix or Windows, respectively). Then, in the run dropdown menu, select "backend" and hit run to get the GCE server running. Once it is running, you should see in the terminal that the server is up.

3. Run the App
Now you should see the app appear on your phone or emulator. Depending on whether you installed the free or paid version, you should see either an ad popup at the bottom of the screen, or now ad at all, respectively. Clicking on the button should redirect you to another page with a great pun.

4. Test the App
To run the test cases, go to the Gradle pane on the right side of the IDE and under :app, Tasks, verification, click connectedCheck which runs all Android tests.
