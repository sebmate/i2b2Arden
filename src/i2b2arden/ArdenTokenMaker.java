package i2b2arden;

import javax.swing.text.Segment;
import org.fife.ui.rsyntaxtextarea.AbstractTokenMaker;
import org.fife.ui.rsyntaxtextarea.RSyntaxUtilities;
import org.fife.ui.rsyntaxtextarea.Token;
import org.fife.ui.rsyntaxtextarea.TokenMap;
import org.fife.ui.rsyntaxtextarea.TokenTypes;

public class ArdenTokenMaker
        extends AbstractTokenMaker
        implements TokenTypes {

    String source;

    @Override
    public void addToken(Segment segment, int start, int end, int tokenType, int startOffset) {
        // This assumes all keywords, etc. were parsed as "identifiers."
        if (tokenType == Token.IDENTIFIER) {
            int value = wordsToHighlight.get(segment, start, end);
            if (value != -1) {
                tokenType = value;
            }
        }
        super.addToken(segment, start, end, tokenType, startOffset);
    }

    @Override
    public TokenMap getWordsToHighlight() {
        TokenMap tokenMap = new TokenMap();

        tokenMap.put("abs", Token.RESERVED_WORD);
        tokenMap.put("action", Token.RESERVED_WORD);
        tokenMap.put("after", Token.RESERVED_WORD);
        tokenMap.put("ago", Token.RESERVED_WORD);
        tokenMap.put("alert", Token.RESERVED_WORD);
        tokenMap.put("all", Token.RESERVED_WORD);
        tokenMap.put("and", Token.RESERVED_WORD);
        tokenMap.put("any", Token.RESERVED_WORD);
        tokenMap.put("arcos", Token.RESERVED_WORD);
        tokenMap.put("arcsin", Token.RESERVED_WORD);
        tokenMap.put("arctan", Token.RESERVED_WORD);
        tokenMap.put("arden", Token.RESERVED_WORD);
        tokenMap.put("are", Token.RESERVED_WORD);
        tokenMap.put("argument", Token.RESERVED_WORD);
        tokenMap.put("as", Token.RESERVED_WORD);
        tokenMap.put("at", Token.RESERVED_WORD);
        tokenMap.put("attribute", Token.RESERVED_WORD);
        tokenMap.put("author", Token.RESERVED_WORD);
        tokenMap.put("average", Token.RESERVED_WORD);
        tokenMap.put("avg", Token.RESERVED_WORD);
        tokenMap.put("be", Token.RESERVED_WORD);
        tokenMap.put("before", Token.RESERVED_WORD);
        tokenMap.put("Boolean", Token.RESERVED_WORD);
        tokenMap.put("call", Token.RESERVED_WORD);
        tokenMap.put("ceiling", Token.RESERVED_WORD);
        tokenMap.put("characters", Token.RESERVED_WORD);
        tokenMap.put("citations", Token.RESERVED_WORD);
        tokenMap.put("conclude", Token.RESERVED_WORD);
        tokenMap.put("cos", Token.RESERVED_WORD);
        tokenMap.put("cosine", Token.RESERVED_WORD);
        tokenMap.put("count", Token.RESERVED_WORD);
        tokenMap.put("clone", Token.RESERVED_WORD);
        tokenMap.put("currenttime", Token.RESERVED_WORD);
        tokenMap.put("data", Token.RESERVED_WORD);
        tokenMap.put("data_driven", Token.RESERVED_WORD);
        tokenMap.put("data-driven", Token.RESERVED_WORD);
        tokenMap.put("date", Token.RESERVED_WORD);
        tokenMap.put("day", Token.RESERVED_WORD);
        tokenMap.put("days", Token.RESERVED_WORD);
        tokenMap.put("decrease", Token.RESERVED_WORD);
        tokenMap.put("delay", Token.RESERVED_WORD);
        tokenMap.put("destination", Token.RESERVED_WORD);
        tokenMap.put("do", Token.RESERVED_WORD);
        tokenMap.put("duration", Token.RESERVED_WORD);
        tokenMap.put("earliest", Token.RESERVED_WORD);
        tokenMap.put("else", Token.RESERVED_WORD);
        tokenMap.put("elseif", Token.RESERVED_WORD);
        tokenMap.put("enddo", Token.RESERVED_WORD);
        tokenMap.put("endif", Token.RESERVED_WORD);
        tokenMap.put("end", Token.RESERVED_WORD);
        tokenMap.put("eq", Token.RESERVED_WORD);
        tokenMap.put("equal", Token.RESERVED_WORD);
        tokenMap.put("event", Token.RESERVED_WORD);
        tokenMap.put("eventtime", Token.RESERVED_WORD);
        tokenMap.put("every", Token.RESERVED_WORD);
        tokenMap.put("evoke", Token.RESERVED_WORD);
        tokenMap.put("exist", Token.RESERVED_WORD);
        tokenMap.put("exists", Token.RESERVED_WORD);
        tokenMap.put("exp", Token.RESERVED_WORD);
        tokenMap.put("expired", Token.RESERVED_WORD);
        tokenMap.put("explanation", Token.RESERVED_WORD);
        tokenMap.put("extract", Token.RESERVED_WORD);
        tokenMap.put("false", Token.RESERVED_WORD);
        tokenMap.put("filename", Token.RESERVED_WORD);
        tokenMap.put("find", Token.RESERVED_WORD);
        tokenMap.put("first", Token.RESERVED_WORD);
        tokenMap.put("floor", Token.RESERVED_WORD);
        tokenMap.put("following", Token.RESERVED_WORD);
        tokenMap.put("for", Token.RESERVED_WORD);
        tokenMap.put("formatted", Token.RESERVED_WORD);
        tokenMap.put("from", Token.RESERVED_WORD);
        tokenMap.put("ge", Token.RESERVED_WORD);
        tokenMap.put("greater", Token.RESERVED_WORD);
        tokenMap.put("gt", Token.RESERVED_WORD);
        tokenMap.put("hour", Token.RESERVED_WORD);
        tokenMap.put("hours", Token.RESERVED_WORD);
        tokenMap.put("if", Token.RESERVED_WORD);
        tokenMap.put("in", Token.RESERVED_WORD);
        tokenMap.put("include", Token.RESERVED_WORD);
        tokenMap.put("increase", Token.RESERVED_WORD);
        tokenMap.put("index", Token.RESERVED_WORD);
        tokenMap.put("institution", Token.RESERVED_WORD);
        tokenMap.put("int", Token.RESERVED_WORD);
        tokenMap.put("interface", Token.RESERVED_WORD);
        tokenMap.put("interval", Token.RESERVED_WORD);
        tokenMap.put("is", Token.RESERVED_WORD);
        tokenMap.put("it", Token.RESERVED_WORD);
        tokenMap.put("keywords", Token.RESERVED_WORD);
        tokenMap.put("knowledge", Token.RESERVED_WORD);
        tokenMap.put("last", Token.RESERVED_WORD);
        tokenMap.put("latest", Token.RESERVED_WORD);
        tokenMap.put("le", Token.RESERVED_WORD);
        tokenMap.put("left", Token.RESERVED_WORD);
        tokenMap.put("length", Token.RESERVED_WORD);
        tokenMap.put("less", Token.RESERVED_WORD);
        tokenMap.put("let", Token.RESERVED_WORD);
        tokenMap.put("library", Token.RESERVED_WORD);
        tokenMap.put("links", Token.RESERVED_WORD);
        tokenMap.put("list", Token.RESERVED_WORD);
        tokenMap.put("log", Token.RESERVED_WORD);
        tokenMap.put("log10", Token.RESERVED_WORD);
        tokenMap.put("logic", Token.RESERVED_WORD);
        tokenMap.put("lowercase", Token.RESERVED_WORD);
        tokenMap.put("lt", Token.RESERVED_WORD);
        tokenMap.put("maintenance", Token.RESERVED_WORD);
        tokenMap.put("matches", Token.RESERVED_WORD);
        tokenMap.put("max", Token.RESERVED_WORD);
        tokenMap.put("maximum", Token.RESERVED_WORD);
        tokenMap.put("median", Token.RESERVED_WORD);
        tokenMap.put("merge", Token.RESERVED_WORD);
        tokenMap.put("message", Token.RESERVED_WORD);
        tokenMap.put("min", Token.RESERVED_WORD);
        tokenMap.put("minimum", Token.RESERVED_WORD);
        tokenMap.put("minute", Token.RESERVED_WORD);
        tokenMap.put("minutes", Token.RESERVED_WORD);
        tokenMap.put("mlm", Token.RESERVED_WORD);
        tokenMap.put("mlmname", Token.RESERVED_WORD);
        tokenMap.put("mlm_self", Token.RESERVED_WORD);
        tokenMap.put("month", Token.RESERVED_WORD);
        tokenMap.put("months", Token.RESERVED_WORD);
        tokenMap.put("names", Token.RESERVED_WORD);
        tokenMap.put("ne", Token.RESERVED_WORD);
        tokenMap.put("nearest", Token.RESERVED_WORD);
        tokenMap.put("new", Token.RESERVED_WORD);
        tokenMap.put("no", Token.RESERVED_WORD);
        tokenMap.put("not", Token.RESERVED_WORD);
        tokenMap.put("now", Token.RESERVED_WORD);
        tokenMap.put("null", Token.RESERVED_WORD);
        tokenMap.put("number", Token.RESERVED_WORD);
        tokenMap.put("object", Token.RESERVED_WORD);
        tokenMap.put("occur", Token.RESERVED_WORD);
        tokenMap.put("occurred", Token.RESERVED_WORD);
        tokenMap.put("occurs", Token.RESERVED_WORD);
        tokenMap.put("of", Token.RESERVED_WORD);
        tokenMap.put("or", Token.RESERVED_WORD);
        tokenMap.put("past", Token.RESERVED_WORD);
        tokenMap.put("pattern", Token.RESERVED_WORD);
        tokenMap.put("percent", Token.RESERVED_WORD);
        tokenMap.put("preceding", Token.RESERVED_WORD);
        tokenMap.put("present", Token.RESERVED_WORD);
        tokenMap.put("priority", Token.RESERVED_WORD);
        tokenMap.put("production", Token.RESERVED_WORD);
        tokenMap.put("purpose", Token.RESERVED_WORD);
        tokenMap.put("read", Token.RESERVED_WORD);
        tokenMap.put("refute", Token.RESERVED_WORD);
        tokenMap.put("research", Token.RESERVED_WORD);
        tokenMap.put("return", Token.RESERVED_WORD);
        tokenMap.put("reverse", Token.RESERVED_WORD);
        tokenMap.put("right", Token.RESERVED_WORD);
        tokenMap.put("round", Token.RESERVED_WORD);
        tokenMap.put("same", Token.RESERVED_WORD);
        tokenMap.put("second", Token.RESERVED_WORD);
        tokenMap.put("seconds", Token.RESERVED_WORD);
        tokenMap.put("seqto", Token.RESERVED_WORD);
        tokenMap.put("sin", Token.RESERVED_WORD);
        tokenMap.put("sine", Token.RESERVED_WORD);
        tokenMap.put("slope", Token.RESERVED_WORD);
        tokenMap.put("sort", Token.RESERVED_WORD);
        tokenMap.put("specialist", Token.RESERVED_WORD);
        tokenMap.put("sqrt", Token.RESERVED_WORD);
        tokenMap.put("starting", Token.RESERVED_WORD);
        tokenMap.put("stddev", Token.RESERVED_WORD);
        tokenMap.put("string", Token.RESERVED_WORD);
        tokenMap.put("substring", Token.RESERVED_WORD);
        tokenMap.put("sum", Token.RESERVED_WORD);
        tokenMap.put("support", Token.RESERVED_WORD);
        tokenMap.put("surrounding", Token.RESERVED_WORD);
        tokenMap.put("tan", Token.RESERVED_WORD);
        tokenMap.put("tangent", Token.RESERVED_WORD);
        tokenMap.put("testing", Token.RESERVED_WORD);
        tokenMap.put("than", Token.RESERVED_WORD);
        tokenMap.put("the", Token.RESERVED_WORD);
        tokenMap.put("then", Token.RESERVED_WORD);
        tokenMap.put("they", Token.RESERVED_WORD);
        tokenMap.put("time", Token.RESERVED_WORD);
        tokenMap.put("title", Token.RESERVED_WORD);
        tokenMap.put("to", Token.RESERVED_WORD);
        tokenMap.put("triggertime", Token.RESERVED_WORD);
        tokenMap.put("trim", Token.RESERVED_WORD);
        tokenMap.put("true", Token.RESERVED_WORD);
        tokenMap.put("truncate", Token.RESERVED_WORD);
        tokenMap.put("type", Token.RESERVED_WORD);
        tokenMap.put("unique", Token.RESERVED_WORD);
        tokenMap.put("until", Token.RESERVED_WORD);
        tokenMap.put("uppercase", Token.RESERVED_WORD);
        tokenMap.put("urgency", Token.RESERVED_WORD);
        tokenMap.put("validation", Token.RESERVED_WORD);
        tokenMap.put("variance", Token.RESERVED_WORD);
        tokenMap.put("version", Token.RESERVED_WORD);
        tokenMap.put("was", Token.RESERVED_WORD);
        tokenMap.put("week", Token.RESERVED_WORD);
        tokenMap.put("weeks", Token.RESERVED_WORD);
        tokenMap.put("were", Token.RESERVED_WORD);
        tokenMap.put("where", Token.RESERVED_WORD);
        tokenMap.put("while", Token.RESERVED_WORD);
        tokenMap.put("with", Token.RESERVED_WORD);
        tokenMap.put("within", Token.RESERVED_WORD);
        tokenMap.put("write", Token.RESERVED_WORD);
        tokenMap.put("year", Token.RESERVED_WORD);
        tokenMap.put("years", Token.RESERVED_WORD);
        tokenMap.put("union", Token.RESERVED_WORD);
        tokenMap.put("intersect", Token.RESERVED_WORD);
        tokenMap.put("excluding", Token.RESERVED_WORD);
        tokenMap.put("citation", Token.RESERVED_WORD);
        tokenMap.put("select", Token.RESERVED_WORD);

        return tokenMap;
    }

    /**
     * Returns a list of tokens representing the given text.
     *
     * @param text The text to break into tokens.
     * @param startTokenType The token with which to start tokenizing.
     * @param startOffset The offset at which the line of tokens begins.
     * @return A linked list of tokens representing <code>text</code>.
     */
    public Token getTokenList(Segment text, int startTokenType, int startOffset) {

        resetTokenList();

        char[] array = text.array;
        int offset = text.offset;
        int count = text.count;
        int end = offset + count;

        // Token starting offsets are always of the form:
        // 'startOffset + (currentTokenStart-offset)', but since startOffset and
        // offset are constant, tokens' starting positions become:
        // 'newStartOffset+currentTokenStart'.
        int newStartOffset = startOffset - offset;
        int currentTokenStart = offset;
        int currentTokenType = startTokenType;

        for (int i = offset; i < end; i++) {

            char c = array[i];

            switch (currentTokenType) {

                case Token.NULL:

                    currentTokenStart = i;   // Starting a new token here.

                    switch (c) {

                        case ' ':
                        case '\t':
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '\'':
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '#':
                            currentTokenType = Token.COMMENT_EOL;
                            break;

                        case '/':

                            if (array[i + 1] == '/') {
                                currentTokenType = Token.COMMENT_EOL;

                            }
                            break;

                        default:
                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) /*|| c == '/' */ || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }

                            // Anything not currently handled - mark as an identifier
                            currentTokenType = Token.IDENTIFIER;
                            break;

                    } // End of switch (c).

                    break;

                case Token.WHITESPACE:

                    switch (c) {

                        case ' ':
                        case '\t':
                            break;   // Still whitespace.

                        case '"':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '\'':

                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '#':
                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.COMMENT_EOL;
                            break;

                        case '/':

                            if (array[i + 1] == '/') {
                                addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                                currentTokenStart = i;
                                currentTokenType = Token.COMMENT_EOL;
                            }

                            break;

                        default:   // Add the whitespace token and start anew.

                            addToken(text, currentTokenStart, i - 1, Token.WHITESPACE, newStartOffset + currentTokenStart);
                            currentTokenStart = i;

                            if (RSyntaxUtilities.isDigit(c)) {
                                currentTokenType = Token.LITERAL_NUMBER_DECIMAL_INT;
                                break;
                            } else if (RSyntaxUtilities.isLetter(c) /*|| c == '/'*/ || c == '_') {
                                currentTokenType = Token.IDENTIFIER;
                                break;
                            }

                            // Anything not currently handled - mark as identifier
                            currentTokenType = Token.IDENTIFIER;

                    } // End of switch (c).

                    break;

                default: // Should never happen

                case Token.IDENTIFIER:

                    switch (c) {

                        case ' ':
                        case '\t':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '\'':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case ':':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            //currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '(':
                            addToken(text, currentTokenStart, i - 1, Token.IDENTIFIER, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            //currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        default:
                            if (RSyntaxUtilities.isLetterOrDigit(c) /*|| c == '/' */ || c == '_') {
                                break;   // Still an identifier of some type.
                            }
                        // Otherwise, we're still an identifier (?).

                    } // End of switch (c).

                    break;

                case Token.LITERAL_NUMBER_DECIMAL_INT:

                    switch (c) {

                        case ' ':
                        case '\t':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.WHITESPACE;
                            break;

                        case '"':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        case '\'':
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            currentTokenStart = i;
                            currentTokenType = Token.LITERAL_STRING_DOUBLE_QUOTE;
                            break;

                        default:

                            if (RSyntaxUtilities.isDigit(c)) {
                                break;   // Still a literal number.
                            }

                            // Otherwise, remember this was a number and start over.
                            addToken(text, currentTokenStart, i - 1, Token.LITERAL_NUMBER_DECIMAL_INT, newStartOffset + currentTokenStart);
                            i--;
                            currentTokenType = Token.NULL;

                    } // End of switch (c).

                    break;

                case Token.COMMENT_EOL:
                    i = end - 1;
                    addToken(text, currentTokenStart, i, currentTokenType, newStartOffset + currentTokenStart);
                    // We need to set token type to null so at the bottom we don't add one more token.
                    currentTokenType = Token.NULL;
                    break;

                case Token.LITERAL_STRING_DOUBLE_QUOTE:
                    if (c == '"') {
                        addToken(text, currentTokenStart, i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    if (c == '\'') {
                        addToken(text, currentTokenStart, i, Token.LITERAL_STRING_DOUBLE_QUOTE, newStartOffset + currentTokenStart);
                        currentTokenType = Token.NULL;
                    }
                    break;

            } // End of switch (currentTokenType).

        } // End of for (int i=offset; i<end; i++).

        switch (currentTokenType) {

            // Remember what token type to begin the next line with.
            case Token.LITERAL_STRING_DOUBLE_QUOTE:
                addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
                break;

            // Do nothing if everything was okay.
            case Token.NULL:
                addNullToken();
                break;

            // All other token types don't continue to the next line...
            default:
                addToken(text, currentTokenStart, end - 1, currentTokenType, newStartOffset + currentTokenStart);
                addNullToken();

        }

        // Return the first token in our linked list.
        return firstToken;

    }

}
