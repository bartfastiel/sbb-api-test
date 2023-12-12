package com.example.sbbapitest;

import java.util.List;

public record SbbResponse(
        int total_count,
        List< SbbResult > results
) {
}
