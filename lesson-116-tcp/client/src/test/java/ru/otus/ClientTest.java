package ru.otus;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {
	private final ByteArrayOutputStream receiveFromClientBuffer = new ByteArrayOutputStream();
	private final Client client = new Client(new SendToClientStream(), receiveFromClientBuffer);

	private final ByteArrayOutputStream sendToClientByteStream = new ByteArrayOutputStream();
	private final DataOutputStream sendToClientStream = new DataOutputStream(sendToClientByteStream);

	private DataInputStream readFromClientStream() {
		return new DataInputStream(new ByteArrayInputStream(receiveFromClientBuffer.toByteArray()));
	}

	private class SendToClientStream extends InputStream {
		int pos;
		byte[] source;

		@Override
		public int read() {
			if (source == null) {
				source = sendToClientByteStream.toByteArray();
			}

			if (pos < source.length) return source[pos++];
			return -1;
		}
	}

	@Test
	void add() throws Exception {
		sendToClientStream.writeInt(42);

		assertThat(client.add(1, 2)).isEqualTo(42);

		var readFromClientStream = readFromClientStream();
		assertThat(readFromClientStream.readUTF()).isEqualTo("add");
		assertThat(readFromClientStream.readInt()).isEqualTo(1);
		assertThat(readFromClientStream.readInt()).isEqualTo(2);
	}

}