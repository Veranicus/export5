package com.tieto.export.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.w3c.dom.Element;
import org.xhtmlrenderer.extend.FSImage;
import org.xhtmlrenderer.extend.ReplacedElement;
import org.xhtmlrenderer.extend.ReplacedElementFactory;
import org.xhtmlrenderer.extend.UserAgentCallback;
import org.xhtmlrenderer.layout.LayoutContext;
import org.xhtmlrenderer.pdf.ITextFSImage;
import org.xhtmlrenderer.pdf.ITextImageElement;
import org.xhtmlrenderer.pdf.ITextUserAgent;
import org.xhtmlrenderer.render.BlockBox;
import org.xhtmlrenderer.simple.extend.FormSubmissionListener;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;

public class MediaReplacedElementFactory implements ReplacedElementFactory {
    private final ReplacedElementFactory superFactory;

    private static final String IMAGE_PATH= "images/";
    
    public MediaReplacedElementFactory(ReplacedElementFactory superFactory) {
        this.superFactory = superFactory;
    }

    @Override
    public ReplacedElement createReplacedElement(LayoutContext layoutContext, BlockBox blockBox,
    		UserAgentCallback userAgentCallback, int cssWidth, int cssHeight) {
    	
        Element element = blockBox.getElement();
        if (element == null) {
            return null;
        }
        String nodeName = element.getNodeName();
        String className = element.getAttribute("class");
        
        //replacing all <div class="media data-src="sourceName"/> with binary data of 'sourceName'
        if ("div".equals(nodeName) && ("media".equals(className) || "mediaLogo".equals(className))) {
            if (!element.hasAttribute("data-src")) {	
                throw new NullPointerException("Image replacement: Element with class 'media' is missing 'data-src' attribute");
            }

            try {
            	//loading image
                final Image image= loadImageData(element, "/opt/portal/microservices/export/images/"); // TODO Does not work in JAR!
                //scaling
                final int factor = ((ITextUserAgent)userAgentCallback).getSharedContext().getDotsPerPixel();
                image.scaleAbsolute(image.getPlainWidth() * factor, image.getPlainHeight() * factor);
                
                final FSImage fsImage = new ITextFSImage(image);
                if ((cssWidth != -1) || (cssHeight != -1)) {
                    fsImage.scale(cssWidth, cssHeight);
                }
                return new ITextImageElement(fsImage);
            } catch (Exception e) {
                throw new NullPointerException("There was a problem trying to read a template embedded graphic.");
            }
        }
        return this.superFactory.createReplacedElement(layoutContext, blockBox, userAgentCallback, cssWidth, cssHeight);
    }
    
    private Image loadImageData(Element element, String path) throws IOException, BadElementException {
    	final byte[] bytes= Files.readAllBytes(new File(path + element.getAttribute("data-src")).toPath());
        return Image.getInstance(bytes);
    }
    
    @Override
    public void reset() {
        this.superFactory.reset();
    }

    @Override
    public void remove(Element e) {
        this.superFactory.remove(e);
    }

    @Override
    public void setFormSubmissionListener(FormSubmissionListener listener) {
        this.superFactory.setFormSubmissionListener(listener);
    }
}