package utils.runners;

import models.JSplitterModel;
import org.jetbrains.annotations.NotNull;

final class JSplitterRunner {
    static synchronized void run(@NotNull JSplitterModel jSplitterModel, int count_of_pieces_in_width , int count_of_pieces_in_height) {
        jSplitterModel.getImageSplitter().split(count_of_pieces_in_width , count_of_pieces_in_height);
    }
}
