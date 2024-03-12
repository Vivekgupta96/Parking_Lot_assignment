package Model;

import java.time.LocalDateTime;

public class Token {
	private String tokenId;
    private LocalDateTime timestamp;

    public Token(String tokenId) {
        this.tokenId = tokenId;
        this.timestamp = LocalDateTime.now();
    }

    public String getTokenId() {
        return tokenId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
