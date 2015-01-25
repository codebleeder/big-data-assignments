lines = LOAD 'input/sample.txt' AS (line:chararray);
words = FOREACH lines GENERATE FLATTEN(TOKENIZE(REPLACE(line,'([^a-zA-Z\\s]+)',' '))) AS word;
lowerWords = FOREACH words GENERATE LOWER(word) AS lowerWord;
filteredWords = FILTER lowerWords BY (lowerWord == 'hackathon') or (lowerWord == 'java') or (lowerWord == 'chicago') or (lowerWord == 'dec');
grouped = GROUP filteredWords by lowerWord; 
wordsCount = FOREACH grouped GENERATE group, COUNT(filteredWords);
STORE wordsCount INTO 'out/';


