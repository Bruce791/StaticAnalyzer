grammar Grammar;

mainProgram : frame_ISO_7bit EOF ;

frame_ISO_7bit :  (Alpha decimal_number (Whitespace+)?)+  ;

decimal_number : ('-')? Digit+ ('.' Digit+)? ;

Digit : [0-9] ;

Alpha : [a-zA-Z] ;

Whitespace : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+ /*-> skip */ ;
