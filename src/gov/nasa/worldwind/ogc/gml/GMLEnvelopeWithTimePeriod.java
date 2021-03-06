/*
 * Copyright (C) 2014 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */

package gov.nasa.worldwind.ogc.gml;

/**
 * @author tag
 * @version $Id$
 */
public class GMLEnvelopeWithTimePeriod extends GMLEnvelope
{
    public GMLEnvelopeWithTimePeriod(String namespaceURI)
    {
        super(namespaceURI);
    }

    public Object getBeginPosition()
    {
        return this.getField("beginPosition");
    }

    public Object getEndPosition()
    {
        return this.getField("endPosition");
    }
}
