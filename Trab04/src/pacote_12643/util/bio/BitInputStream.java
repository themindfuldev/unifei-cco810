package pacote_12643.util.bio;

// $Id$

import java.io.*;

/**
 * InputStream que trabalha com bits.
 */
public class BitInputStream
{
	/**
	 * Referência InputStream
	 */
	private InputStream in;
	/**
	 * Buffer de bits
	 */
	private int buffer;
	/**
	 * Indicação do próximo bit
	 */
	private int nextBit = 8;

	// Construtor
	public BitInputStream(InputStream in)
	{
		this.in = in;
	}

	/**
	 * Lê um bit.
	 * 
	 * @return
	 * @throws IOException
	 */
	synchronized public int readBit() throws IOException
	{
		if (in == null)
			throw new IOException("Already closed");

		if (nextBit == 8)
		{
			buffer = in.read();

			if (buffer == -1)
				throw new EOFException();

			nextBit = 0;
		}

		int bit = buffer & (1 << nextBit);
		nextBit++;

		bit = bit == 0 ? 0 : 1;

		return bit;
	}

	/**
	 * Fecha o stream.
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		in.close();
		in = null;
	}
}
