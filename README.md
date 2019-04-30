# SciFi UI Project

Name: Niall Williams

Student Number: C17511003

Fork this repository and use it a starter project for your assignment

# Description of the assignment
The UI I designed is for a space-age mining vessel. It can scan planets from a distance and determine:
- The mass of the planet
- The percentage of the crust that is made up of:
	- iron
	- gold
	- uranium

It is possible to examine individual planets on seperate screens. From these screens a more thourough scan can be conducted, determining:
- The percentage of mass that is mad up of water water.
- The average tempreture of the plaent's surface.
- If there are any life forms on the planet and how advanced they are.
- How habitable the atmosphere is for humans.

# Instructions
When first running the program, a window with 5 planets will be displayed. In order to comence a scan of a planet you click on it.

After the scan is complete the basic information will display. If you click on a scanned planet then it opens uo a new window.

This window will display the planet that you clicked on, as well as the basic information from the initial scan. By clicking on the deep

scan button in the bottom right you can start a more thourough scan. Once that scan is complete more information will become available. You can 
open up seperate windows for each planet simultaniuosly, but you are unable to open up 2 windows for the same planet. 

# How it works
There is an abstract class that the main window and the individual planet windows extend. There is also an abstract class for the objects that will be
drawn onto the UIs. There is a UI class that is used to generate the main window and create the instances of the planet class. There is an OrbitalView class
that generates a window for a single planet.

There is a class for planets  that is initialized using data read in from a table. This class has a method to display a picture from the data folder at given
coordinate and a given size. This method also displays information contained within the fields if the planet has been scanned. There is a seperate method used
to display the planet and information on a single-window from OrbitalView.

There is a scanner class that generates a graphic around an unscanned planet when that planet is clicked. Once a set period of time has passed, the scanned
sets the scanned field in the planet that it is scanning to true.

There is a DeepScan class that renders the graphics for the more thourough scan of individual planets. This class is also used to determine how much information
the planet displays.

The radar class displays an eliptical radar at given co-ordinates of a given height and width.
 

# What I am most proud of in the assignment
I am most proud of the extra windows that are opened up for the orbital view of the individual planets. While not particularly difficult, it is not someting
that would be immediately obvious to do. 

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

