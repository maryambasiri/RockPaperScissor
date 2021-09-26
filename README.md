# RockPaperScissor

## Why
When I started to learn functional programming I was wondering all the time, 
what is the meaning of pure functions. What can I do with them if I can't have any side effects inside 
a pure function? How is it possible to write something without dealing with a database, Input-Output, 
or without having Exceptions?
Then I realized that we can use IO Mondas to deal with any Input-Output like console and Database, etc.
We can use Either and Option to deal with Exceptions and chain the processes using these data structures 
to let our application's flow continue.

But still, with all this great stuff, It doesn't make sense to postpone the side effects forever, 
even in the purest functional languages we need to finally run the side effects somewhere.
The missing key was that we only need to have a core pure program and there we should write everything 
as pure functions to make our program testable and modular. Around that core, 
we could have a thin layer of an unpure program that is responsible to run our pure codes. 
That thin layer could be the Main method of our application.
Here in this example, I'm trying to show that even using ZIO we can postpone our side effects for a while 
and finally we need to run them somewhere. 
But there is a big difference between the code with ZIO and without ZIO.
ZIO helped us to write a few more pure functions in our UI module that was dealing with IO, therefore we end up 
with a bigger core pure program.

## How 
I used [this Reference](https://en.wikipedia.org/wiki/Rock_paper_scissors) for the algorithm to determine 
the winner

**rock-paper-scissors-lizard-Spock**

One popular five-weapon expansion is "rock paper scissors Spock lizard", invented by Sam Kass and
Karen Bryla,[95] which adds "Spock" and "lizard" to the standard three choices. "Spock" is signified
with the Star Trek Vulcan salute, while "lizard" is shown by forming the hand into a sock-puppet-like
mouth. Spock smashes scissors and vaporizes rock; he is poisoned by lizard and disproved by paper. 
Lizard poisons Spock and eats paper; it is crushed by rock and decapitated by scissors. 

**determine the winner**

The majority of such proposed generalizations are isomorphic to a simple game of modular arithmetic,
where half the differences are wins for player one. For instance, Rock-Paper-Scissors-Spock-Lizard may be
modeled as a game in which each player picks a number from one to five. Subtract the number chosen
by player two from the number chosen by player one, and then take the remainder modulo 5 of the result.
Player one is the victor if the difference is one or three, and player two is the victor if the difference
is two or four. If the difference is zero, the game is a tie.
