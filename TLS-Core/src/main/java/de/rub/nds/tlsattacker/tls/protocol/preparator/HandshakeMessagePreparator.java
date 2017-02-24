/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.protocol.preparator;

import de.rub.nds.tlsattacker.tls.protocol.handshake.HandshakeMessage;
import de.rub.nds.tlsattacker.tls.workflow.TlsContext;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public abstract class HandshakeMessagePreparator<T extends HandshakeMessage> extends Preparator<T> {

    private final HandshakeMessage message;

    public HandshakeMessagePreparator(TlsContext context, T message) {
        super(context, message);
        this.message = message;
    }

    public void prepareMessageLength(int length) {
        message.setLength(length);
    }

}