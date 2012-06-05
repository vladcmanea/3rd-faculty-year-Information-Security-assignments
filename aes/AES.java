/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aes;

/**
 * @version 1.0
 * @author vlad manea
 */
public class AES {

    private int Nk, Nb, Nr;
    private char wK[][];
    private static final char dS[][] = {
        {(char) (6 * 16 + 3), (char) (7 * 16 + 12), (char) (7 * 16 + 7), (char) (7 * 16 + 11), (char) (15 * 16 + 2), (char) (6 * 16 + 11), (char) (6 * 16 + 15), (char) (12 * 16 + 5), (char) (3 * 16 + 0), (char) (0 * 16 + 1), (char) (6 * 16 + 7), (char) (2 * 16 + 11), (char) (15 * 16 + 14), (char) (13 * 16 + 7), (char) (10 * 16 + 11), (char) (7 * 16 + 6)},
        {(char) (12 * 16 + 10), (char) (8 * 16 + 2), (char) (12 * 16 + 9), (char) (7 * 16 + 13), (char) (15 * 16 + 10), (char) (5 * 16 + 9), (char) (4 * 16 + 7), (char) (15 * 16 + 0), (char) (10 * 16 + 13), (char) (13 * 16 + 4), (char) (10 * 16 + 2), (char) (10 * 16 + 15), (char) (9 * 16 + 12), (char) (10 * 16 + 4), (char) (7 * 16 + 2), (char) (12 * 16 + 0)},
        {(char) (11 * 16 + 7), (char) (15 * 16 + 13), (char) (9 * 16 + 3), (char) (2 * 16 + 6), (char) (3 * 16 + 6), (char) (3 * 16 + 15), (char) (15 * 16 + 7), (char) (12 * 16 + 12), (char) (3 * 16 + 4), (char) (10 * 16 + 5), (char) (14 * 16 + 5), (char) (15 * 16 + 1), (char) (7 * 16 + 1), (char) (13 * 16 + 8), (char) (3 * 16 + 1), (char) (1 * 16 + 5)},
        {(char) (0 * 16 + 4), (char) (12 * 16 + 7), (char) (2 * 16 + 3), (char) (12 * 16 + 3), (char) (1 * 16 + 8), (char) (9 * 16 + 6), (char) (0 * 16 + 5), (char) (9 * 16 + 10), (char) (0 * 16 + 7), (char) (1 * 16 + 2), (char) (8 * 16 + 0), (char) (14 * 16 + 2), (char) (14 * 16 + 11), (char) (2 * 16 + 7), (char) (11 * 16 + 2), (char) (7 * 16 + 5)},
        {(char) (0 * 16 + 9), (char) (8 * 16 + 3), (char) (2 * 16 + 12), (char) (1 * 16 + 10), (char) (1 * 16 + 11), (char) (6 * 16 + 14), (char) (5 * 16 + 10), (char) (10 * 16 + 0), (char) (5 * 16 + 2), (char) (3 * 16 + 11), (char) (13 * 16 + 6), (char) (11 * 16 + 3), (char) (2 * 16 + 9), (char) (14 * 16 + 3), (char) (2 * 16 + 15), (char) (8 * 16 + 4)},
        {(char) (5 * 16 + 3), (char) (13 * 16 + 1), (char) (0 * 16 + 0), (char) (14 * 16 + 13), (char) (2 * 16 + 0), (char) (15 * 16 + 12), (char) (11 * 16 + 1), (char) (5 * 16 + 11), (char) (6 * 16 + 10), (char) (12 * 16 + 11), (char) (11 * 16 + 14), (char) (3 * 16 + 9), (char) (4 * 16 + 10), (char) (4 * 16 + 12), (char) (5 * 16 + 8), (char) (12 * 16 + 15)},
        {(char) (13 * 16 + 0), (char) (14 * 16 + 15), (char) (10 * 16 + 10), (char) (15 * 16 + 11), (char) (4 * 16 + 3), (char) (4 * 16 + 13), (char) (3 * 16 + 3), (char) (8 * 16 + 5), (char) (4 * 16 + 5), (char) (15 * 16 + 9), (char) (0 * 16 + 2), (char) (7 * 16 + 15), (char) (5 * 16 + 0), (char) (3 * 16 + 12), (char) (9 * 16 + 15), (char) (10 * 16 + 8)},
        {(char) (5 * 16 + 1), (char) (10 * 16 + 3), (char) (4 * 16 + 0), (char) (8 * 16 + 15), (char) (9 * 16 + 2), (char) (9 * 16 + 13), (char) (3 * 16 + 8), (char) (15 * 16 + 5), (char) (11 * 16 + 12), (char) (11 * 16 + 6), (char) (13 * 16 + 10), (char) (2 * 16 + 1), (char) (1 * 16 + 0), (char) (15 * 16 + 15), (char) (15 * 16 + 3), (char) (13 * 16 + 2)},
        {(char) (12 * 16 + 13), (char) (0 * 16 + 12), (char) (1 * 16 + 3), (char) (14 * 16 + 12), (char) (5 * 16 + 15), (char) (9 * 16 + 7), (char) (4 * 16 + 4), (char) (1 * 16 + 7), (char) (12 * 16 + 4), (char) (10 * 16 + 7), (char) (7 * 16 + 14), (char) (3 * 16 + 13), (char) (6 * 16 + 4), (char) (5 * 16 + 13), (char) (1 * 16 + 9), (char) (7 * 16 + 3)},
        {(char) (6 * 16 + 0), (char) (8 * 16 + 1), (char) (4 * 16 + 15), (char) (13 * 16 + 12), (char) (2 * 16 + 2), (char) (2 * 16 + 10), (char) (9 * 16 + 0), (char) (8 * 16 + 8), (char) (4 * 16 + 6), (char) (14 * 16 + 14), (char) (11 * 16 + 8), (char) (1 * 16 + 4), (char) (13 * 16 + 14), (char) (5 * 16 + 14), (char) (0 * 16 + 11), (char) (13 * 16 + 11)},
        {(char) (14 * 16 + 0), (char) (3 * 16 + 2), (char) (3 * 16 + 10), (char) (0 * 16 + 10), (char) (4 * 16 + 9), (char) (0 * 16 + 6), (char) (2 * 16 + 4), (char) (5 * 16 + 12), (char) (12 * 16 + 2), (char) (13 * 16 + 3), (char) (10 * 16 + 12), (char) (6 * 16 + 2), (char) (9 * 16 + 1), (char) (9 * 16 + 5), (char) (14 * 16 + 4), (char) (7 * 16 + 9)},
        {(char) (14 * 16 + 7), (char) (12 * 16 + 8), (char) (3 * 16 + 7), (char) (6 * 16 + 13), (char) (8 * 16 + 13), (char) (13 * 16 + 5), (char) (4 * 16 + 14), (char) (10 * 16 + 9), (char) (6 * 16 + 12), (char) (5 * 16 + 6), (char) (15 * 16 + 4), (char) (14 * 16 + 10), (char) (6 * 16 + 5), (char) (7 * 16 + 10), (char) (10 * 16 + 14), (char) (0 * 16 + 8)},
        {(char) (11 * 16 + 10), (char) (7 * 16 + 8), (char) (2 * 16 + 5), (char) (2 * 16 + 14), (char) (1 * 16 + 12), (char) (10 * 16 + 6), (char) (11 * 16 + 4), (char) (12 * 16 + 6), (char) (14 * 16 + 8), (char) (13 * 16 + 13), (char) (7 * 16 + 4), (char) (1 * 16 + 15), (char) (4 * 16 + 11), (char) (11 * 16 + 13), (char) (8 * 16 + 11), (char) (8 * 16 + 10)},
        {(char) (7 * 16 + 0), (char) (3 * 16 + 14), (char) (11 * 16 + 5), (char) (6 * 16 + 6), (char) (4 * 16 + 8), (char) (0 * 16 + 3), (char) (15 * 16 + 6), (char) (0 * 16 + 14), (char) (6 * 16 + 1), (char) (3 * 16 + 5), (char) (5 * 16 + 7), (char) (11 * 16 + 9), (char) (8 * 16 + 6), (char) (12 * 16 + 1), (char) (1 * 16 + 13), (char) (9 * 16 + 14)},
        {(char) (14 * 16 + 1), (char) (15 * 16 + 8), (char) (9 * 16 + 8), (char) (1 * 16 + 1), (char) (6 * 16 + 9), (char) (13 * 16 + 9), (char) (8 * 16 + 14), (char) (9 * 16 + 4), (char) (9 * 16 + 11), (char) (1 * 16 + 14), (char) (8 * 16 + 7), (char) (14 * 16 + 9), (char) (12 * 16 + 14), (char) (5 * 16 + 5), (char) (2 * 16 + 8), (char) (13 * 16 + 15)},
        {(char) (8 * 16 + 12), (char) (10 * 16 + 1), (char) (8 * 16 + 9), (char) (0 * 16 + 13), (char) (11 * 16 + 15), (char) (14 * 16 + 6), (char) (4 * 16 + 2), (char) (6 * 16 + 8), (char) (4 * 16 + 1), (char) (9 * 16 + 9), (char) (2 * 16 + 13), (char) (0 * 16 + 15), (char) (11 * 16 + 0), (char) (5 * 16 + 4), (char) (11 * 16 + 11), (char) (1 * 16 + 6)}
    };
    private static final char iS[][] = {
        {(char) (5 * 16 + 2), (char) (0 * 16 + 9), (char) (6 * 16 + 10), (char) (13 * 16 + 5), (char) (3 * 16 + 0), (char) (3 * 16 + 6), (char) (10 * 16 + 5), (char) (3 * 16 + 8), (char) (11 * 16 + 15), (char) (4 * 16 + 0), (char) (10 * 16 + 3), (char) (9 * 16 + 14), (char) (8 * 16 + 1), (char) (15 * 16 + 3), (char) (13 * 16 + 7), (char) (15 * 16 + 11)},
        {(char) (7 * 16 + 12), (char) (14 * 16 + 3), (char) (3 * 16 + 9), (char) (8 * 16 + 2), (char) (9 * 16 + 11), (char) (2 * 16 + 15), (char) (15 * 16 + 15), (char) (8 * 16 + 7), (char) (3 * 16 + 4), (char) (8 * 16 + 14), (char) (4 * 16 + 3), (char) (4 * 16 + 4), (char) (12 * 16 + 4), (char) (13 * 16 + 14), (char) (14 * 16 + 9), (char) (12 * 16 + 11)},
        {(char) (5 * 16 + 4), (char) (7 * 16 + 11), (char) (9 * 16 + 4), (char) (3 * 16 + 2), (char) (10 * 16 + 6), (char) (12 * 16 + 2), (char) (2 * 16 + 3), (char) (3 * 16 + 13), (char) (14 * 16 + 14), (char) (4 * 16 + 12), (char) (9 * 16 + 5), (char) (0 * 16 + 11), (char) (4 * 16 + 2), (char) (15 * 16 + 10), (char) (12 * 16 + 3), (char) (4 * 16 + 14)},
        {(char) (0 * 16 + 8), (char) (2 * 16 + 14), (char) (10 * 16 + 1), (char) (6 * 16 + 6), (char) (2 * 16 + 8), (char) (13 * 16 + 9), (char) (2 * 16 + 4), (char) (11 * 16 + 2), (char) (7 * 16 + 6), (char) (5 * 16 + 11), (char) (10 * 16 + 2), (char) (4 * 16 + 9), (char) (6 * 16 + 13), (char) (8 * 16 + 11), (char) (13 * 16 + 1), (char) (2 * 16 + 5)},
        {(char) (7 * 16 + 2), (char) (15 * 16 + 8), (char) (15 * 16 + 6), (char) (6 * 16 + 4), (char) (8 * 16 + 6), (char) (6 * 16 + 8), (char) (9 * 16 + 8), (char) (1 * 16 + 6), (char) (13 * 16 + 4), (char) (10 * 16 + 4), (char) (5 * 16 + 12), (char) (12 * 16 + 12), (char) (5 * 16 + 13), (char) (6 * 16 + 5), (char) (11 * 16 + 6), (char) (9 * 16 + 2)},
        {(char) (6 * 16 + 12), (char) (7 * 16 + 0), (char) (4 * 16 + 8), (char) (5 * 16 + 0), (char) (15 * 16 + 13), (char) (14 * 16 + 13), (char) (11 * 16 + 9), (char) (13 * 16 + 10), (char) (5 * 16 + 14), (char) (1 * 16 + 5), (char) (4 * 16 + 6), (char) (5 * 16 + 7), (char) (10 * 16 + 7), (char) (8 * 16 + 13), (char) (9 * 16 + 13), (char) (8 * 16 + 4)},
        {(char) (9 * 16 + 0), (char) (13 * 16 + 8), (char) (10 * 16 + 11), (char) (0 * 16 + 0), (char) (8 * 16 + 12), (char) (11 * 16 + 12), (char) (13 * 16 + 3), (char) (0 * 16 + 10), (char) (15 * 16 + 7), (char) (14 * 16 + 4), (char) (5 * 16 + 8), (char) (0 * 16 + 5), (char) (11 * 16 + 8), (char) (11 * 16 + 3), (char) (4 * 16 + 5), (char) (0 * 16 + 6)},
        {(char) (13 * 16 + 0), (char) (2 * 16 + 12), (char) (1 * 16 + 14), (char) (8 * 16 + 15), (char) (12 * 16 + 10), (char) (3 * 16 + 15), (char) (0 * 16 + 15), (char) (0 * 16 + 2), (char) (12 * 16 + 1), (char) (10 * 16 + 15), (char) (11 * 16 + 13), (char) (0 * 16 + 3), (char) (0 * 16 + 1), (char) (1 * 16 + 3), (char) (8 * 16 + 10), (char) (6 * 16 + 11)},
        {(char) (3 * 16 + 10), (char) (9 * 16 + 1), (char) (1 * 16 + 1), (char) (4 * 16 + 1), (char) (4 * 16 + 15), (char) (6 * 16 + 7), (char) (13 * 16 + 12), (char) (14 * 16 + 10), (char) (9 * 16 + 7), (char) (15 * 16 + 2), (char) (12 * 16 + 15), (char) (12 * 16 + 14), (char) (15 * 16 + 0), (char) (11 * 16 + 4), (char) (14 * 16 + 6), (char) (7 * 16 + 3)},
        {(char) (9 * 16 + 6), (char) (10 * 16 + 12), (char) (7 * 16 + 4), (char) (2 * 16 + 2), (char) (14 * 16 + 7), (char) (10 * 16 + 13), (char) (3 * 16 + 5), (char) (8 * 16 + 5), (char) (14 * 16 + 2), (char) (15 * 16 + 9), (char) (3 * 16 + 7), (char) (14 * 16 + 8), (char) (1 * 16 + 12), (char) (7 * 16 + 5), (char) (13 * 16 + 15), (char) (6 * 16 + 14)},
        {(char) (4 * 16 + 7), (char) (15 * 16 + 1), (char) (1 * 16 + 10), (char) (7 * 16 + 1), (char) (1 * 16 + 13), (char) (2 * 16 + 9), (char) (12 * 16 + 5), (char) (8 * 16 + 9), (char) (6 * 16 + 15), (char) (11 * 16 + 7), (char) (6 * 16 + 2), (char) (0 * 16 + 14), (char) (10 * 16 + 10), (char) (1 * 16 + 8), (char) (11 * 16 + 14), (char) (1 * 16 + 11)},
        {(char) (15 * 16 + 12), (char) (5 * 16 + 6), (char) (3 * 16 + 14), (char) (4 * 16 + 11), (char) (12 * 16 + 6), (char) (13 * 16 + 2), (char) (7 * 16 + 9), (char) (2 * 16 + 0), (char) (9 * 16 + 10), (char) (13 * 16 + 11), (char) (12 * 16 + 0), (char) (15 * 16 + 14), (char) (7 * 16 + 8), (char) (12 * 16 + 13), (char) (5 * 16 + 10), (char) (15 * 16 + 4)},
        {(char) (1 * 16 + 15), (char) (13 * 16 + 13), (char) (10 * 16 + 8), (char) (3 * 16 + 3), (char) (8 * 16 + 8), (char) (0 * 16 + 7), (char) (12 * 16 + 7), (char) (3 * 16 + 1), (char) (11 * 16 + 1), (char) (1 * 16 + 2), (char) (1 * 16 + 0), (char) (5 * 16 + 9), (char) (2 * 16 + 7), (char) (8 * 16 + 0), (char) (14 * 16 + 12), (char) (5 * 16 + 15)},
        {(char) (6 * 16 + 0), (char) (5 * 16 + 1), (char) (7 * 16 + 15), (char) (10 * 16 + 9), (char) (1 * 16 + 9), (char) (11 * 16 + 5), (char) (4 * 16 + 10), (char) (0 * 16 + 13), (char) (2 * 16 + 13), (char) (14 * 16 + 5), (char) (7 * 16 + 10), (char) (9 * 16 + 15), (char) (9 * 16 + 3), (char) (12 * 16 + 9), (char) (9 * 16 + 12), (char) (14 * 16 + 15)},
        {(char) (10 * 16 + 0), (char) (14 * 16 + 0), (char) (3 * 16 + 11), (char) (4 * 16 + 13), (char) (10 * 16 + 14), (char) (2 * 16 + 10), (char) (15 * 16 + 5), (char) (11 * 16 + 0), (char) (12 * 16 + 8), (char) (14 * 16 + 11), (char) (11 * 16 + 11), (char) (3 * 16 + 12), (char) (8 * 16 + 3), (char) (5 * 16 + 3), (char) (9 * 16 + 9), (char) (6 * 16 + 1)},
        {(char) (1 * 16 + 7), (char) (2 * 16 + 11), (char) (0 * 16 + 4), (char) (7 * 16 + 14), (char) (11 * 16 + 10), (char) (7 * 16 + 7), (char) (13 * 16 + 6), (char) (2 * 16 + 6), (char) (14 * 16 + 1), (char) (6 * 16 + 9), (char) (1 * 16 + 4), (char) (6 * 16 + 3), (char) (5 * 16 + 5), (char) (2 * 16 + 1), (char) (0 * 16 + 12), (char) (7 * 16 + 13)}
    };
    private static char Rc[] = {
        (char) (0x8d), (char) (0x01), (char) (0x02), (char) (0x04), (char) (0x08), (char) (0x10), (char) (0x20), (char) (0x40), (char) (0x80), (char) (0x1b), (char) (0x36), (char) (0x6c), (char) (0xd8), (char) (0xab), (char) (0x4d), (char) (0x9a), (char) (0x2f), (char) (0x5e), (char) (0xbc), (char) (0x63), (char) (0xc6), (char) (0x97), (char) (0x35), (char) (0x6a), (char) (0xd4), (char) (0xb3), (char) (0x7d), (char) (0xfa), (char) (0xef), (char) (0xc5), (char) (0x91), (char) (0x39), (char) (0x72), (char) (0xe4), (char) (0xd3), (char) (0xbd), (char) (0x61), (char) (0xc2), (char) (0x9f), (char) (0x25), (char) (0x4a), (char) (0x94), (char) (0x33), (char) (0x66), (char) (0xcc), (char) (0x83), (char) (0x1d), (char) (0x3a), (char) (0x74), (char) (0xe8), (char) (0xcb), (char) (0x8d), (char) (0x01), (char) (0x02), (char) (0x04), (char) (0x08), (char) (0x10), (char) (0x20), (char) (0x40), (char) (0x80), (char) (0x1b), (char) (0x36), (char) (0x6c), (char) (0xd8),
        (char) (0xab), (char) (0x4d), (char) (0x9a), (char) (0x2f), (char) (0x5e), (char) (0xbc), (char) (0x63), (char) (0xc6), (char) (0x97), (char) (0x35), (char) (0x6a), (char) (0xd4), (char) (0xb3), (char) (0x7d), (char) (0xfa), (char) (0xef), (char) (0xc5), (char) (0x91), (char) (0x39), (char) (0x72), (char) (0xe4), (char) (0xd3), (char) (0xbd), (char) (0x61), (char) (0xc2), (char) (0x9f), (char) (0x25), (char) (0x4a), (char) (0x94), (char) (0x33), (char) (0x66), (char) (0xcc), (char) (0x83), (char) (0x1d), (char) (0x3a), (char) (0x74), (char) (0xe8), (char) (0xcb), (char) (0x8d), (char) (0x01), (char) (0x02), (char) (0x04), (char) (0x08), (char) (0x10), (char) (0x20), (char) (0x40), (char) (0x80), (char) (0x1b), (char) (0x36), (char) (0x6c), (char) (0xd8), (char) (0xab), (char) (0x4d), (char) (0x9a), (char) (0x2f), (char) (0x5e), (char) (0xbc), (char) (0x63), (char) (0xc6), (char) (0x97), (char) (0x35), (char) (0x6a), (char) (0xd4), (char) (0xb3),
        (char) (0x7d), (char) (0xfa), (char) (0xef), (char) (0xc5), (char) (0x91), (char) (0x39), (char) (0x72), (char) (0xe4), (char) (0xd3), (char) (0xbd), (char) (0x61), (char) (0xc2), (char) (0x9f), (char) (0x25), (char) (0x4a), (char) (0x94), (char) (0x33), (char) (0x66), (char) (0xcc), (char) (0x83), (char) (0x1d), (char) (0x3a), (char) (0x74), (char) (0xe8), (char) (0xcb), (char) (0x8d), (char) (0x01), (char) (0x02), (char) (0x04), (char) (0x08), (char) (0x10), (char) (0x20), (char) (0x40), (char) (0x80), (char) (0x1b), (char) (0x36), (char) (0x6c), (char) (0xd8), (char) (0xab), (char) (0x4d), (char) (0x9a), (char) (0x2f), (char) (0x5e), (char) (0xbc), (char) (0x63), (char) (0xc6), (char) (0x97), (char) (0x35), (char) (0x6a), (char) (0xd4), (char) (0xb3), (char) (0x7d), (char) (0xfa), (char) (0xef), (char) (0xc5), (char) (0x91), (char) (0x39), (char) (0x72), (char) (0xe4), (char) (0xd3), (char) (0xbd), (char) (0x61), (char) (0xc2), (char) (0x9f),
        (char) (0x25), (char) (0x4a), (char) (0x94), (char) (0x33), (char) (0x66), (char) (0xcc), (char) (0x83), (char) (0x1d), (char) (0x3a), (char) (0x74), (char) (0xe8), (char) (0xcb), (char) (0x8d), (char) (0x01), (char) (0x02), (char) (0x04), (char) (0x08), (char) (0x10), (char) (0x20), (char) (0x40), (char) (0x80), (char) (0x1b), (char) (0x36), (char) (0x6c), (char) (0xd8), (char) (0xab), (char) (0x4d), (char) (0x9a), (char) (0x2f), (char) (0x5e), (char) (0xbc), (char) (0x63), (char) (0xc6), (char) (0x97), (char) (0x35), (char) (0x6a), (char) (0xd4), (char) (0xb3), (char) (0x7d), (char) (0xfa), (char) (0xef), (char) (0xc5), (char) (0x91), (char) (0x39), (char) (0x72), (char) (0xe4), (char) (0xd3), (char) (0xbd), (char) (0x61), (char) (0xc2), (char) (0x9f), (char) (0x25), (char) (0x4a), (char) (0x94), (char) (0x33), (char) (0x66), (char) (0xcc), (char) (0x83), (char) (0x1d), (char) (0x3a), (char) (0x74), (char) (0xe8), (char) (0xcb)
    };

    /**
     * AES
     * @param type
     * @param key
     * @throws Exception
     */
    public AES(int type, char[] key) throws Exception {
        if (type == 128) {
            Nk = 4;
            Nb = 4;
            Nr = 10;
        } else if (type == 192) {
            Nk = 6;
            Nb = 4;
            Nr = 12;
        } else if (type == 256) {
            Nk = 8;
            Nb = 4;
            Nr = 14;
        } else {
            throw new Exception("[AES.AES] Invalid type: " + type);
        }
        if (key.length != 4 * Nk) {
            throw new Exception("[AES.AES] Invalid key: " + key);
        }
        wK = new char[4][(Nr + 1) * Nb];
        ExpandKey(key);
    }

    /**
     * SubWord
     * @param key
     * @return
     */
    private char[] SubWord(char[] key) {
        char[] answer = new char[4];
        for (int r = 0; r < 4; ++r) {
            char lo = (char) (key[r] & 15), hi = (char) ((key[r] >> 4) & 15);
            answer[r] = dS[hi][lo];
        }
        return answer;
    }

    /**
     * RotWord
     * @param key
     * @return
     */
    private char[] RotWord(char[] key) {
        char[] answer = new char[4];
        for (int r = 0; r < 4; ++r) {
            answer[r] = key[(r + 1) % 4];
        }
        return answer;
    }

    /**
     * ExpandKey
     */
    private void ExpandKey(char[] key) {
        char[] temp = new char[4];
        for (int c = 0; c < Nk; ++c) {
            for (int r = 0; r < 4; ++r) {
                wK[r][c] = key[4 * c + r];
            }
        }
        for (int c = Nk; c < Nb * (Nr + 1); ++c) {
            for (int r = 0; r < 4; ++r) {
                temp[r] = wK[r][c - 1];
            }
            if (c % Nk == 0) {
                temp = RotWord(temp);
                temp = SubWord(temp);
                temp[0] ^= Rc[c / Nk];
            } else if (Nk > 6 && c % Nk == 4) {
                temp = SubWord(temp);
            }
            for (int r = 0; r < 4; ++r) {
                temp[r] = (char) (wK[r][c - Nk] ^ temp[r]);
            }
            for (int r = 0; r < 4; ++r) {
                wK[r][c] = temp[r];
            }
        }
    }

    /**
     * InputToState
     * @param input
     * @return
     */
    private char[][] InputToState(char[] input) {
        char[][] stans = new char[4][Nb];
        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                stans[r][c] = input[r + 4 * c];
            }
        }
        return stans;
    }

    /**
     * StateToOutput
     * @param state
     * @return
     */
    private char[] StateToOutput(char[][] state) {
        char[] txans = new char[4 * Nb];
        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                txans[r + 4 * c] = state[r][c];
            }
        }
        return txans;
    }

    /**
     * AddRoundKey
     * @param state
     * @param L
     * @param R
     * @return
     */
    private char[][] AddRoundKey(char[][] state, int l) {
        char[][] answer = new char[4][Nb];
        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                answer[r][c] = (char) (state[r][c] ^ wK[r][l + c]);
            }
        }
        return answer;
    }

    /**
     * Subchars
     * @param state
     * @return
     */
    private char[][] DirSubchars(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                char lo = (char) (state[r][c] & 15);
                char hi = (char) ((state[r][c] >> 4) & 15);
                answer[r][c] = dS[hi][lo];
            }
        }
        return answer;
    }

    /**
     * Shift
     * @param r
     * @param Nb
     * @return
     */
    private int Shift(int r, int Nb) {
        return r;
    }

    /**
     * ShiftRows
     * @param state
     * @return
     */
    private char[][] DirShiftRows(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int c = 0; c < Nb; ++c) {
            answer[0][c] = state[0][c];
        }
        for (int r = 1; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                answer[r][c] = (char) (state[r][(c + Shift(r, Nb)) % Nb]);
            }
        }
        return answer;
    }

    /**
     * Multiply4
     * @param a
     * @param b
     * @return
     */
    private char Multiply(char a, char b) {
        char answer = 0, r = a;
        boolean ok;
        for (int x = 0; x < 8; ++x) {
            if ((b & (1 << x)) > 0) {
                answer ^= r;
            }
            if ((r & (1 << 7)) > 0) {
                r = (char) ((r << 1) ^ 283);
            } else {
                r <<= 1;
            }
        }
        return answer;
    }

    /**
     * MixColumns
     * @param state
     * @return
     */
    private char[][] DirMixColumns(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int c = 0; c < Nb; ++c) {
            answer[0][c] = (char) ((Multiply((char) (2), state[0][c])
                    ^ Multiply((char) (3), state[1][c])
                    ^ state[2][c]
                    ^ state[3][c]));
            answer[1][c] = (char) ((state[0][c]
                    ^ Multiply((char) (2), state[1][c])
                    ^ Multiply((char) (3), state[2][c])
                    ^ state[3][c]));
            answer[2][c] = (char) ((state[0][c]
                    ^ state[1][c]
                    ^ Multiply((char) (2), state[2][c])
                    ^ Multiply((char) (3), state[3][c])));
            answer[3][c] = (char) ((Multiply((char) (3), state[0][c])
                    ^ state[1][c]
                    ^ state[2][c]
                    ^ Multiply((char) (2), state[3][c])));
        }
        return answer;
    }

    /**
     * Encrypt
     * @param text
     * @return
     */
    public char[] Encrypt(char[] text) throws Exception {
        if (text.length != 16) {
            throw new Exception("[AES.encrypt] Invalid text: " + text);
        }
        char[][] state = new char[4][Nb];
        state = InputToState(text);
        state = AddRoundKey(state, 0);
        for (int r = 1; r < Nr; ++r) {
            state = DirSubchars(state);
            state = DirShiftRows(state);
            state = DirMixColumns(state);
            state = AddRoundKey(state, r * Nb);
        }
        state = DirSubchars(state);
        state = DirShiftRows(state);
        state = AddRoundKey(state, Nr * Nb);
        text = StateToOutput(state);
        return text;
    }

    private char[][] InvShiftRows(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int c = 0; c < Nb; ++c) {
            answer[0][c] = state[0][c];
        }
        for (int r = 1; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                answer[r][c] = state[r][(Nb + c - Shift(r, Nb)) % Nb];
            }
        }
        return answer;

    }

    private char[][] InvSubchars(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int r = 0; r < 4; ++r) {
            for (int c = 0; c < Nb; ++c) {
                char lo = (char) (state[r][c] & 15);
                char hi = (char) ((state[r][c] >> 4) & 15);
                answer[r][c] = iS[hi][lo];
            }
        }
        return answer;
    }

    private char[][] InvMixColumns(char[][] state) {
        char[][] answer = new char[4][Nb];
        for (int c = 0; c < Nb; ++c) {
            answer[0][c] = (char) (Multiply((char) (14), state[0][c])
                    ^ Multiply((char) (11), state[1][c])
                    ^ Multiply((char) (13), state[2][c])
                    ^ Multiply((char) (9), state[3][c]));
            answer[1][c] = (char) (Multiply((char) (9), state[0][c])
                    ^ Multiply((char) (14), state[1][c])
                    ^ Multiply((char) (11), state[2][c])
                    ^ Multiply((char) (13), state[3][c]));
            answer[2][c] = (char) (Multiply((char) (13), state[0][c])
                    ^ Multiply((char) (9), state[1][c])
                    ^ Multiply((char) (14), state[2][c])
                    ^ Multiply((char) (11), state[3][c]));
            answer[3][c] = (char) (Multiply((char) (11), state[0][c])
                    ^ Multiply((char) (13), state[1][c])
                    ^ Multiply((char) (9), state[2][c])
                    ^ Multiply((char) (14), state[3][c]));
        }
        return answer;
    }

    /**
     * Decrypt
     * @param text
     * @return
     */
    public char[] Decrypt(char[] text) throws Exception {
        if (text.length != 16) {
            throw new Exception("[AES.decrypt] Invalid text: " + text);
        }
        char[][] state = new char[4][Nb];
        state = InputToState(text);
        state = AddRoundKey(state, Nr * Nb);
        for (int r = Nr - 1; r >= 1; --r) {
            state = InvShiftRows(state);
            state = InvSubchars(state);
            state = AddRoundKey(state, r * Nb);
            state = InvMixColumns(state);
        }
        state = InvShiftRows(state);
        state = InvSubchars(state);
        state = AddRoundKey(state, 0);
        text = StateToOutput(state);
        return text;
    }

    /**
     * Aux
     * @param x
     * @return
     */
    public static String Aux(char x) {
        Integer v = Integer.valueOf(x);
        return Integer.toHexString(v);
    }

    /**
     * Aux
     * @param x
     * @return
     */
    public static String Aux(char[] x) {
        String v = "";
        for (int i = 0; i < x.length; ++i) {
            v += ' ' + Integer.toHexString(x[i]);
        }
        return v;
    }

    /**
     * Aux
     * @param x
     * @return
     */
    public static String Aux(char[][] x) {
        String v = "";
        for (int i = 0; i < x.length; ++i) {
            for (int j = 0; j < x[0].length; ++j) {
                v += ' ' + Integer.toHexString(x[i][j]);
            }
        }
        return v;
    }
}
