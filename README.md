# ProgrammingProject2k20
Exam project for the object programming course

## Table of contents
* [Introduction](#Introduction)
* [Technologies](#Technologies)
* [Launch](#Launch)
* [How it works](#How it works)

## Introduction
The designed application is aimed to show data and statistics on twitter posts containing images. The user can apply the same command on a sample of all the data using filters.

## How it works
How the app works can be divided in two main parts:
1 the download of the information from Twitter
2 the show to the user what he has requested

### The download of the informations
When the app is launched, it automatically downloads from Twitter all the tweets that are rapresented in a file with their ids.
If the file isn't found the user sees a message error. Each tweet is contained in a Record that is composed of the most important informations and all togheter composed the database. 

(inserire sequence diagram inizializzazione)

After this, the general stats about the field "height", "width" and megapixel are calcuted and stored in an ArrayList of variabiles Stats.

### The show to the user whats he has requested
After the inizialization, the user can insert some different roots (each root provides to show different informations from the database)
| Root | Method | What the user sees | What the user has to add in the body |
|---------|---------|---------|-------|
| /GetInstructions | GET | The user sees a simply manual of how the app works | |
| /GetMetadata | GET | The user sees the alias used for a variabile, the type and te meaning | |
| /GetStats | GET | The user sees all the stats calculated on the all set of data | |
| /GetData | GET | The user sees all the tweets downloaded from Twitter | |
| /GetData | POST | The user sees the Tweets that satisfy the filter added by the user | A correct filter |
| /GetFieldStats | GET | The user sees the stats of a particular field calculated using the all databse | |
| /GetFieldStats | POST | The user sees the stats of a particular field calcutaed using the records that satisfy the filter | A correct filter |

## Launch
![tekst alternatywny](immagine)

## Technologies
* [Eclipse](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)
* [Spring Boot]
* [Maven]

## Code Examples
To generate lorem ipsum use special shortcode: `SpringApplication.run(Esame2k20Application.class, args);`
