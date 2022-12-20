package nostr.json.parser.impl;

import nostr.json.parser.JsonParseException;
import nostr.json.parser.BaseParser;
import nostr.json.values.JsonNumberValue;
import java.util.logging.Level;
import lombok.extern.java.Log;

/**
 *
 * @author squirrel
 */
@Log
public class JsonNumberParser extends BaseParser<JsonNumberValue> {

    public JsonNumberParser(String json) {
        super(json.trim());
        log.log(Level.FINE, "Parsing number {0}", json.trim());
    }

    @Override
    public JsonNumberValue parse() throws JsonParseException {
        try {
            return new JsonNumberValue(Double.valueOf(json));
        } catch (NumberFormatException ex) {
            throw new JsonParseException(ex);
        }
    }

}