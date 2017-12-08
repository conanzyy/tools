package com.only.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Created by 17021687 on 2017/12/8.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			ByteBuf buf = (ByteBuf) msg;
			byte[] data = new byte[buf.readableBytes()];
			buf.readBytes(data);
			System.out.println("Client：" + new String(data).trim());
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}


	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}