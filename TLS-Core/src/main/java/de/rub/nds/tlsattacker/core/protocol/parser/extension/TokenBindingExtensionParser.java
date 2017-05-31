/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2017 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.parser.extension;

import de.rub.nds.tlsattacker.core.constants.ExtensionByteLength;
import de.rub.nds.tlsattacker.core.constants.TokenBindingKeyParameters;
import de.rub.nds.tlsattacker.core.constants.TokenBindingVersion;
import de.rub.nds.tlsattacker.core.protocol.message.extension.TokenBindingExtensionMessage;

/**
 *
 * @author Matthias Terlinde <matthias.terlinde@rub.de>
 */
public class TokenBindingExtensionParser extends ExtensionParser<TokenBindingExtensionMessage> {

    public TokenBindingExtensionParser(int startposition, byte[] array) {
        super(startposition, array);
    }

    @Override
    public void parseExtensionMessageContent(TokenBindingExtensionMessage msg) {
        msg.setMajor(TokenBindingVersion
                .getExtensionType(parseByteField(ExtensionByteLength.TOKENBINDING_VERSION_LENGTH)));
        msg.setMinor(TokenBindingVersion
                .getExtensionType(parseByteField(ExtensionByteLength.TOKENBINDING_VERSION_LENGTH)));
        msg.setParameterListLength(parseIntField(1));
        msg.setTokenbindingParameters(parseByteArrayField(msg.getParameterListLength()));
        LOGGER.debug("The token binding extension parser parsed the major version: " + msg.getMajor().toString()
                + " the minor version: " + msg.getMinor().toString() + " and the key binding parameters.");
    }

    @Override
    protected TokenBindingExtensionMessage createExtensionMessage() {
        LOGGER.debug("Created a new token binding extension message");
        return new TokenBindingExtensionMessage();
    }

}
