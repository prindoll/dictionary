# Application to support learning English using Java

## Author
Group 29
1. Le Tien Thuc - 22021197
2. Tran Van Quang - 22021198
3. Le Quang Thang - 22021209

## Description
The application is designed to support learning English. The application is written in Java and uses the JavaFX library. 
The application is based on the MVC model. The application has two types of dictionaries: English-Vietnamese and Vietnamese-English. The application use E_V.txt and V_E.txt files to store data.
1. Rich Vocabulary Repository:
  The application offers a diverse vocabulary bank, including everyday language and specialized terms. Explore words in various contexts to deepen your understanding.
2. Clear Pronunciations:
  Each word in the dictionary comes with accurate audio pronunciations, aiding you in honing your listening and speaking skills with precision.
3. Search History:
  Never lose track of your learning journey. The search history feature helps you revisit and reinforce the vocabulary you've explored.
4. Bookmark Your Favorites:
  Personalize your learning experience by bookmarking your favorite words. Build a custom list of go-to vocabulary for quick reference and reinforcement.
5. Game :
  Challenge yourself with short quizzes and educational games that make learning enjoyable and flexible. Track your progress and celebrate your achievements. We has a two game help you to improve English
6. Google Translate Integration:
  The application to use Google Translate API for swift and accurate translations. Expand your understanding by accessing a wealth of linguistic resources seamlessly.

## UML diagram
![UML diagram](

## Installation
1. Clone the project from the repository.
2. Open the project in the IDE.
3. Run the project.
4. If you want to change the data, you can change the E_V.txt and V_E.txt files.

## Usage
1. Select mode: English-Vietnamese or Vietnamese-English to choose the dictionary.
2. Search for a word in the dictionary and click the Search button, then the right side of the window will display the meaning of the word.
3. To add a new word, click the Add button (Plus icon).
4. To delete a word, click the Delete button (Minus icon).
5. To bookmark a word, click the Bookmark button (Star icon).
6. To pronounce the word, click the Pronounce button (Speaker icon).
7. To practice , click the Game button (Game icon), then the application will display a Game window.
   + In the Game window, we have two game to study English : HangMan and BearFindHoney.
   + Click to button Hangman or BearFIndHoney to start game .
   + Hang man :
    - The computer will randomly select a word related to the topic currently on the screen .
    - Your job is to guess the word through its letters . If you true , this letter to print in the screen , else not and your character will gradually appear, if it is complete you die .
  + BearFIndHoney :
    - Click to Button Start to start game .
    - Use keys a, s, w, d to move the bear to the destination where there is honey and you will win .
    - If you encounter questions , you must answer to questions to continue move else you only 3 time wrong so you can lose .
    - Please help the bear to fine honey.
8 . You can use API GoogleTranslate yo  translate the word ì you want .
8. To exit the application, click the Exit button (Cross icon).

## Demo
![Demo](

## Future improvements
1. Add more dictionaries.
2. Add more complex games.
3. Optimize the word lookup algorithm.
4. Use a database to store data.
5. Integrate the application with API of Google Translate to translate paragraphs and whole documents.
6. Integrate the application with API of Google Speech to Text to convert speech to text.
7. Improve the user interface.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## Project status
The project is completed.

## Notes
The application is written for educational purposes.
