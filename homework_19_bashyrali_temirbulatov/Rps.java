public enum Rps {
    ROCK, PAPER, SCISSORS,LIZARD,SPOCK;
    
    public int compareMoves(Rps otherMove) {
        // Ничья
        if (this == otherMove)
        return 0;
        
        switch (this) {
            case ROCK:
            return (otherMove == SCISSORS || otherMove == LIZARD ? 1 : -1 );
            case PAPER:
            return (otherMove == ROCK || otherMove == SPOCK ? 1 : -1);
            case SCISSORS:
            return (otherMove == PAPER || otherMove == LIZARD ? 1 : -1);
            case LIZARD:
            return(otherMove == SPOCK || otherMove == PAPER ? 1: -1 );
            case SPOCK:
            return(otherMove == ROCK || otherMove == SCISSORS ? 1: -1);
        }
        return 0;
    }
}


