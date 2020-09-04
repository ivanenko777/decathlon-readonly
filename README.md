# Decathlon
> Vilnius Coding Shool - Java Project

### Tasks
The task is about Decathlon competition.
The input of the Java program is a CSV-like text file [(see the attachment)](Decathlon_input.txt). The task is to output an XML file with all athletes in ascending order of their places, containing all the input data plus total score and the place in the competition (in case of equal scores, athletes must share the places, e.g. 3-4 and 3-4 instead of 3 and 4). Input and output file names should be provided as parameters to the Java application at the startup. It would be great if an [XSL](Decathlon_output.xsl) file for viewing the produced [XML](Decathlon_output.xml) nicely using a web browser is also provided.

Some links: http://en.wikipedia.org/wiki/Decathlon (see formulas are at the end of the page).

Try to keep your code as readable as possible. We value code simplicity. Use object-oriented approach.

Good luck!

### Setup Firefox to view XSL in browser
setup FF
1. In a new tab, type or paste about:config in the address bar and press Enter/Return. Click the button promising to be careful or accepting the risk.
2. In the search box above the list, type or paste uniq and pause while the list is filtered
3. Double-click the privacy.file_unique_origin preference to switch the value from true to false
