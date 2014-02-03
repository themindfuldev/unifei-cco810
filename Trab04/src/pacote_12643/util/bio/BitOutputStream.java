package pacote_12643.util.bio;

// $Id$

import java.io.*;

/**
 * OutputStream que trabalha com bits.
 */
public class BitOutputStream
{
	/**
	 * Referência OutputStream.
	 */
	private OutputStream out;
	/**
	 * Buffer de bits.
	 */
	private int buffer;
	/**
	 * Contador
	 */
	private int bitCount;

	// Construtor
	public BitOutputStream(OutputStream out)
	{
		this.out = out;
	}

	/**
	 * Escreve um bit.
	 * 
	 * @param bit
	 * @throws IOException
	 */
	synchronized public void writeBit(int bit) throws IOException
	{
		if (out == null)
			throw new IOException("Already closed");

		if (bit != 0 && bit != 1)
		{
			throw new IOException(bit + " is not a bit");
		}

		buffer |= bit << bitCount;
		bitCount++;

		if (bitCount == 8)
		{
			flush();
		}
	}

	/**
	 * Limpa o stream.
	 * 
	 * @throws IOException
	 */
	private void flush() throws IOException
	{
		if (bitCount > 0)
		{
			out.write((byte) buffer);
			bitCount = 0;
			buffer = 0;
		}
	}

	/**
	 * Fecha o stream.
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		flush();
		out.close();
		out = null;
	}
}
