# Upbeat
The goal of our project was to alleviate some of the sadness during this pandemic. Music has been scentifically proven to have an impact on people's mood. We decided to make a project that texts users a new song categorized as a "happy" song by Spotify every morning.

Our desired UI would be that users can sign up to be put on our mailing list through a website, however we were not able to implement this portion in time. For the time being we just store an ArrayList of phone numbers hard coded into the program and text each number in the list.

We implemented this by using the Spotify and the Twilio APIs. We first retrieve song URLs from the Spotify database by making a get call. We filter it so that we only recieve songs with the "genre_seed" tag of happy songs. Then we pass the song URL into the UserInfo class to be checked if we have ever sent that User the song yet. If the song URL is unique then we pass the URL to the Twilio API which makes a call to send an SMS to a user. We have a scheduler function that sets the timer to text the user everyday at 8AM.

Issues we encountered were that Spotify only gives tokens that expire every 6 minutes, so we needed to implement an API call that generates a new token for us everytime our program is called from the schedular. This took a lot of time to figure out because something was off with our input going through the OAuth 2.0 check. We were eventually able to debug this by using a different method.

Future work to be done would be to clean up the code, and to implement a UI to go along with our program.
