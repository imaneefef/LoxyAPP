
# Loxy Mobile Computing Project

## Description

Loxy is a mobile application designed to securely store and manage username-password details for various applications and websites. The app ensures convenience by providing quick access to saved credentials and additional features like automatic logouts after periods of inactivity. Loxy also uses motion sensors for gesture-based interactions, enabling users to open the search bar and view multiple saved credentials with a simple motion.

## Activities

The app contains the following key activities:

1. **Sign-up/Sign-in**: 
   - Users can sign up or sign in to the app by creating an account with a secure username and password.
  
2. **Saved Usernames-Passwords**: 
   - A list view that displays all saved credentials. Users can scroll through their credentials or search for specific usernames and passwords using the search bar.

3. **Insert New Username-Password-Application Set**: 
   - Users can add new credentials to the app by entering the username, password, and application/website name. This information is securely saved within the app.

4. **Delete Credential**: 
   - Users can delete any saved credential by selecting it from the list and confirming the deletion.

## Intents

Loxy uses intents for different user interactions, including:

- **Intent to launch the Sign-up/Sign-in screen** when the user is not logged in.
- **Intent to open the Saved Usernames-Passwords screen** where users can view and search for their credentials.
- **Intent to add new credentials** when users choose to insert a new username-password-application set.
- **Intent to delete a credential** when users opt to remove a saved username-password entry.

## Background Services/Threads

Loxy uses background services to manage functionality and automatic logouts:

- **Inactivity Timer**: A background service monitors time passed since the user last signed in and logs them out automatically after 2 hours for security purposes.
  
- **Motion Sensor Detection**: The app uses a background thread to monitor motion sensors. When a specific gesture is detected (e.g., a motion that triggers the search bar), the app allows users to view their saved credentials instantly.

## Sensors Used

- **Motion Sensor**: Loxy utilizes motion sensors (such as the accelerometer) to detect gestures, like opening the search bar or viewing saved credentials. This feature provides a hands-free interface for users.

## Additional Features

- **Security**: Loxy employs secure encryption techniques to store sensitive data (usernames, passwords, and associated applications) within the app.
  
- **Search Bar**: The app provides an intuitive search bar that allows users to quickly find saved credentials, making it easier to manage and retrieve login information.

## References
-ChatGpt
-StackOverFlow


## Group Members

1. **Name**: Imane Abdelbassir
   Email: abdelbassirimane15@gmail.com

2. **Name**: Anaïs Kessal
   Email: ania.kessal@gmail.com


## Professor

**Name**:  Kotzinos Dimitrios
**Email**: [Dimitrios.Kotzinos@u-cergy.fr](mailto:D%69%6di%74%72%69%6fs.%4b%6f%74%7a%69n%6f%73@u-c%65%72%67%79%2e%66%72)

## Notes
- We will provide two versions of the code. The "SafeLog" project can not be launched and could not be completed due to gradle issues but can still be reviewed. While incomplete, it still implements some useful methods
- Some features are not fully fonctional yet, such as the Alarm system that we could not properly test, and the sensor in the background. All of the necessary methods have been implemented but a last minute API issue prevented them from being fully functional. The parts causing errors were marked as comentaries to not disturb the other features
-  We will make sure that these issues are corrected for the final presentation and will provide you with a functional version within the next days so these aspects can be tested and showcased if you wish so

- Although the app was originally requested to run on a maximum API level of 30 (Android 11), we have opted to use API level 35 (Android 12) for the following reasons:

1. Compatibility with Modern Features
New APIs and Features: Android 12 introduced a variety of new features and APIs that improve user experience and performance. These include enhanced privacy features, smoother animations, and new UI components, which we wanted to take advantage of.
Material You: Android 12 introduced a new design system called Material You, which provides a more dynamic and customizable UI. This feature was leveraged to enhance the look and feel of the app, adapting it to different system themes and colors.
2. Privacy Enhancements
Android 12 brought significant privacy changes, including the Microphone and Camera indicators, Privacy Dashboard, and Approximate Location Permissions. These changes were important for maintaining the app's security and privacy standards in line with current Android practices.
By using API 35, the app takes full advantage of these features, ensuring compliance with modern privacy standards.
3. Better Performance
Improved Background Restrictions: Android 12 introduced better control over background processes, which allows the app to manage background services and tasks more efficiently, reducing battery consumption and improving overall app performance.
The improvements in multi-core processing and memory management on newer Android versions provide a better, more responsive experience for users.
4. Targeting Latest Android Devices
App Optimization for Newer Devices: With Android 12 and later versions being used on a growing percentage of Android devices, supporting API level 35 ensures that users with the latest devices get the best performance and feature support.
The use of Haptic Feedback and Gesture Navigation in Android 12 made the app more intuitive for users with newer devices, enhancing the user experience.
5. Developer Tools & Debugging
Advanced Debugging Tools: Android 12 brought improvements to the Android Debug Bridge (ADB) and Logcat tools, which made it easier to test and debug the app.
Using a higher API level allows developers to take full advantage of these tools for better performance, easier debugging, and more detailed insights during the app development and testing phases.
6. Security Improvements
Android 12 introduced several important security updates and protections that are critical for keeping the app secure, including enhanced app sandboxing and improved data protection mechanisms.
By targeting API 35, we ensure that our app benefits from the latest security patches and mitigations provided by the Android platform.
7. Backward Compatibility
Although we are targeting API level 35, the app is still backward compatible with lower API levels, down to API 21 (Android 5.0 Lollipop). This ensures that users with older devices can still run the app without issues while benefiting from new features on supported devices.
