/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */

package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.IsLiked;

public class IsLikedImpl
	extends BaseSchemaEntity
    implements IsLiked
{

    private final static long serialVersionUID = 2461660169443089969L;
    protected boolean isLiked;

    public boolean isIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean value) {
        this.isLiked = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("is-liked")) {
        		setIsLiked(Boolean.parseBoolean(XppUtils.getElementValueFromNode(parser)));
            } else {
                // Consume something we don't understand.
            	LOG.warning("Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "is-liked");
		XppUtils.setElementValueToNode(element, "is-liked", isIsLiked());
		serializer.endTag(null, "is-liked");
	}
}