#!/usr/bin/perl
read(STDIN, $buffer, $ENV{'CONTENT_LENGTH'});
printf "Content length: $ENV{'CONTENT_LENGTH'} $buffer\n";
@pairs = split(/#/, $buffer);
foreach $pair (@pairs)
{
    ($name, $value) = split(/=/, $pair);
    $value =~ tr/+/ /;
    $value =~ s/%([a-fA-F0-9][a-fA-F0-9])/pack("C", hex($1))/eg;
    # Stop people from using subshells to execute commands
    $value =~ s/~!/ ~!/g;
    $FORM{$name} = $value;
}

#$path = "/home/tapia/public_html/cgi-bin/";
$file = "$FORM{'label'}";
#$url = "http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/";

open(MATH, ">", "$file.math");
printf MATH "TextForm[\"\\batchmode\"] >>> $file.tex\n";
printf MATH "TextForm[\"\\documentclass[12pt]{article}\"] >>> $file.tex\n";
printf MATH "TextForm[\"\\pagestyle{empty}\"] >>> $file.tex\n";
printf MATH "TextForm[\"\\begin{document}\"] >>> $file.tex\n";
printf MATH "TextForm[\"\\Large\"] >>> $file.tex\n";
printf MATH "TextForm[\"\$\$\"] >>> $file.tex\n";
printf MATH "TeXForm[$FORM{'latex'}] >>> $file.tex\n";
printf MATH "TextForm[\"\$\$\"] >>> $file.tex\n";
printf MATH "TextForm[\"\\end{document}\"] >>> $file.tex\n";
close MATH;

system("math < $file.math > /dev/null 2> /dev/null");
system("latex $file.tex > /dev/null 2> /dev/null");
system("dvips $file.dvi -o $file.ps > /dev/null 2> /dev/null");
system("convert -crop 0x0 $file.ps $file.jpg > /dev/null 2> /dev/null");

print "Content-type: text/plain\n\n";
print "Mathematica expression:\n\t$FORM{'latex'}:\n";
print "Saved in file:\n\t$file.tex\n";

exit 0;



