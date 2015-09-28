/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyrighted [2015] [Intellectual Reserve, Inc (IRI)]
 */
package org.forgerock.openam.radius.server.spi.handlers;

import java.util.Properties;

import org.forgerock.openam.radius.common.AccessAccept;
import org.forgerock.openam.radius.common.AccessRequest;
import org.forgerock.openam.radius.server.RadiusAuthResult;
import org.forgerock.openam.radius.server.RadiusAuthResultStatus;
import org.forgerock.openam.radius.server.RadiusProcessingException;
import org.forgerock.openam.radius.server.RadiusResponseHandler;
import org.forgerock.openam.radius.server.spi.AccessRequestHandler;

/**
 * Simple handler that sends an AccessAccept for all incoming Radius access requests. This handler can be used to test
 * the connection from the Radius client to OpenAM without engaging the open am infrastructure when troubleshooting.
 */
public class AcceptAllHandler implements AccessRequestHandler {

    @Override
    public void init(Properties config) {
    }

    @Override
    public RadiusAuthResult handle(AccessRequest request, RadiusResponseHandler respHandler)
            throws RadiusProcessingException {
        final AccessAccept resp = new AccessAccept();
        respHandler.send(resp);
        return new RadiusAuthResult(RadiusAuthResultStatus.SUCCESS);
    }

}