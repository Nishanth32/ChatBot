# ChatBot

In this Project, I have done sentimental analysis and LDA on Yelp restaurant reviews to find the sentiments and themes of user reviews to rank the business and restaurants. The goal is to help users by recommending the best restaurants under different categories based on the analysis of user reviews. The importance of customer reviews are well known , the fact is “90% of consumers read online reviews before visiting a business and 88% of consumers trust online reviews as much as personal recommendations”[1]. User reviews dataset for restaurants were taken from Yelp dataset challenge with over 300,000 user reviews.we used Latent dirichlet algorithm to find exacts topics/attributes to classify user reviews under different categories and applied sentimental analysis to predict user ratings using naive bayes classifiers. Ratings predicted through the above techniques are used as source data in recommending restaurants based on user preference. Overall, the obtained results were used as business logic for building an android mobile application named “Feed Me - Voice based food assistant“ which helps user to find the best restaurants under different categories without the need of manually going through each reviews. 

Yelp user reviews and ratings clearly play a major role in determining the fortune of a business as two professors Michael Anderson and Jeremy Magruder from university of California,Berkeley found that “restaurants with a rating improved by just a half a star on a scale of 1 to 5 was much more likely to be full at peak dining times”[2]. However it gets difficult and time consuming for users to read each review manually and identify the restaurants based on their preference. Furthermore this leads user to make decision based on star ratings which can be misleading as ratings doesn’t provide the context and features on which a restaurant is rated. Considering these difficulties and drawbacks our objective is to create a model that can save the time of users in reading large content reviews and help with making decision based on their preferences. To accomplish this we use Natural language processing techniques like LDA and Sentiment analysis that can read the user reviews and find whether a user review about a local restaurant has positive or negative opinions under different context. The predicted results are used for ranking the business and restaurants in different categories and presented to the user through an user friendly voice based android mobile application named Feed-Me. The voice based android mobile application offers the functionality of speech recognition which takes the user’s input and has GPS features to filter the restaurants based on specific location followed by it’s integration with NLP models to recommend the best restaurants under specific location and category for the user.

![Architecture](https://github.com/Nishanth32/ChatBot/blob/master/Architecture.JPG)

Data preprocessing:

Filtering restaurant data

Filtering country wise data

Language filter

Methodology:
	
Sentimental Analysis:
		
Unigram, Bigram, Sentence wise etc...

Topic Modelling:

LDA

Future works:

Although the performance and prediction accuracy of the model seems convincing after few manual evaluations, there are still lot of spaces for more improvements. In the current methodology the reviews belong to each business is considered as document of input features to LDA statistic model. It is assumed that each unique lexeme in a document is attributable to one of the document topics being grouped. So, a topic has a probability of generating various related words (Lexicon) and can be interpreted by the model to analyze the sentiment of the sentence (sentence in which the lexeme is present) to predict the rating of a restaurant for that category. Since lexicon primarily plays a vital role in predicting the category rating for each restaurant, it becomes important that lexicons should be as accurate as possible while modelling. So, the next step in improving the model classification is to design our own set of lexicons for each category like Food, Service, Ambiance and Discount. We believe that this could potentially improves the identification of relevant topics sentiment for a document resulting in higher accuracy.
Due to the huge size of the dataset, only a subset of the data belonging to a specific location and reviews from English language is employed in training the model. It is both time consuming and inconvenient to analyze the complete data in our computing resource constrained environment. As a future work we planned to involve the complete yelp dataset and offload the training process to Cloud OLAP (Online Analytic Processing) system which improves the overall efficiency of the system.
Yelp Dataset Challenge is an open challenge contest for students to conduct research and analysis on their yelp dataset. We have planned to submit the final prototype of our application project to contest in the challenge.

Conclusion:

In this project we have proposed and implemented an innovative recommendation system for categorizing and identifying the star rating for different restaurants based on the reviews made available through the Yelp dataset. Our recommendation model mainly focuses on predicting the star rating for each business through sentiment analysis of sentences which discriminates the quality of a restaurant. Feedme a Voice based Food assistant developed on android platform is successfully integrated with the recommendation web service and helps user in finding the desired restaurant of their preferred choice. Also, the ability to recognize and interact with user through speech recognition techniques employed and the ability to acquire the current user location and restaurant preferences is an added feature which greatly improves the usability of the application. In the current implementation the voice-based food assistant is capable answering fewer user queries, we left it as a future work to add further intelligence and growing the scope of the assistant in responding to the user queries.

