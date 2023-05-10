parser grammar TemplateMainParser;
@parser::header {
    package rife.template.antlr;
}

options { tokenVocab=TemplateMainLexer; }

document        :   blockContent EOF ;

blockContent    :   (blockData|tagV|tagVDefault|tagB|tagBV|tagBA)* ;
valueContent    :   (valueData|tagB|tagBV|tagBA)*;

tagV        :   TSTART_V TS TTagName TS? TSTERM
            |   CSTART_V CS CTagName CS? CSTERM
            ;

tagVDefault :   TSTART_V TS TTagName TS? TENDI valueContent TCLOSE_V
            |   CSTART_V CS CTagName CS? CENDI valueContent CCLOSE_V
            ;

tagB        :   TSTART_B TS TTagName TS? TENDI blockContent TCLOSE_B
            |   CSTART_B CS CTagName CS? CENDI blockContent CCLOSE_B
            ;

tagBV       :   TSTART_BV TS TTagName TS? TENDI blockContent TCLOSE_BV
            |   CSTART_BV CS CTagName CS? CENDI blockContent CCLOSE_BV
            ;

tagBA       :   TSTART_BA TS TTagName TS? TENDI blockContent TCLOSE_BA
            |   CSTART_BA CS CTagName CS? CENDI blockContent CCLOSE_BA
            ;

// Character data in the document not part of the tags
blockData   :   TEXT+;
valueData   :   TEXT+;
