/*
* sones GraphDB Talend Client Library
* Copyright (C) 2007-2011 sones GmbH - http://www.sones.com
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
*/

package de.sones.mule.demo.transformers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.mule.api.MuleMessage;
import org.mule.api.config.MuleProperties;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class GQLToHttpRequestTransformer extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage message, String arg1)
			throws TransformerException {

		try {
		
		  HttpMethod result;
		
		  //Get the contents of the previous message
		  Object src = message.getPayload();
		
		  System.out.println("Body:" + src.toString());
		  
		  //Get the endpoint which is configured
		  String endpoint = message.getOutboundProperty(MuleProperties.MULE_ENDPOINT_PROPERTY, null);
		  
		  System.out.println("Enpoint:" + endpoint);
		  
		  //Create an uri
		  URI uri = null;
		  
			  
			  uri = new URI(endpoint);
		  
		
		  PostMethod postMethod = new PostMethod(uri.toString());
		 
		  InputStream is = new ByteArrayInputStream(src.toString().getBytes("UTF-8"));
		  
		  postMethod.setRequestBody(src.toString()); 
		
		  result = postMethod;
		  
		  return result;
		  
		}
		catch (Exception e)
		{
			 throw new TransformerException(this, e);
		}
		  
	}

	
	
}
