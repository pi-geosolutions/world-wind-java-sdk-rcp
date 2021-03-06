/*
 * Copyright (C) 2012 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration.
 * All Rights Reserved.
 */
package gov.nasa.worldwindx.examples;

import gov.nasa.worldwind.formats.shapefile.*;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.util.*;
import gov.nasa.worldwindx.examples.util.RandomShapeAttributes;

import javax.swing.*;

/**
 * Illustrates how to import ESRI Shapefiles into World Wind. This uses a <code>{@link ShapefileLayerFactory}</code> to
 * parse a Shapefile's contents and convert the shapefile into an equivalent World Wind shape.
 *
 * @version $Id$
 */
public class Shapefiles extends ApplicationTemplate
{
    public static class AppFrame extends ApplicationTemplate.AppFrame
    {
        public AppFrame()
        {
            // Create an object to generate random attributes.
            final RandomShapeAttributes randomAttrs = new RandomShapeAttributes();

            // Spawn a thread to load the shapefile.
            Thread t = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    ShapefileLayerFactory factory = new ShapefileLayerFactory();

                    // Specify an attribute delegate to assign attributes for each shapefile record.
                    factory.setAttributeDelegate(new ShapefileRenderable.AttributeDelegate()
                    {
                        @Override
                        public void assignAttributes(ShapefileRecord shapefileRecord,
                            ShapefileRenderable.Record renderableRecord)
                        {
                            renderableRecord.setAttributes(randomAttrs.nextAttributes().asShapeAttributes());
                        }
                    });

                    // Load the shapefile. Define the completion callback.
                    factory.createFromShapefileSource("testData/shapefiles/TM_WORLD_BORDERS-0.3.shp",
                        new ShapefileLayerFactory.CompletionCallback()
                        {
                            @Override
                            public void completion(Object result)
                            {
                                final Layer layer = (Layer) result; // the result is the layer the factory created
                                layer.setName(WWIO.getFilename(layer.getName()));

                                // Add the layer to the World Window's layer list on the Event Dispatch Thread.
                                SwingUtilities.invokeLater(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        AppFrame.this.getWwd().getModel().getLayers().add(layer);
                                    }
                                });
                            }

                            @Override
                            public void exception(Exception e)
                            {
                                Logging.logger().log(java.util.logging.Level.SEVERE, e.getMessage(), e);
                            }
                        });
                }
            });
            t.start();
        }
    }

    public static void main(String[] args)
    {
        start("World Wind Shapefiles", AppFrame.class);
    }
}
