package com.only.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by 17021687 on 2017/12/8.
 */
public class ServerHandler  extends ChannelInboundHandlerAdapter
{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		//do something msg
		ByteBuf buf = (ByteBuf)msg;
		byte[] data = new byte[buf.readableBytes()];
		buf.readBytes(data);
		String request = new String(data, "utf-8");
		System.out.println("Server: " + request);
		//写给客户端
		String response = "我是反馈的信息";
		while(true){
			Thread.sleep(1000);
			ctx.writeAndFlush(Unpooled.copiedBuffer("888".getBytes()));
		}
		//.addListener(ChannelFutureListener.CLOSE);


	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}