/*
 * Clover - 4chan browser https://github.com/Floens/Clover/
 * Copyright (C) 2014  Floens
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.floens.controller.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.floens.controller.ControllerTransition;

public class FadeOutTransition extends ControllerTransition {
    @Override
    public void perform() {
        Animator toAlpha = ObjectAnimator.ofFloat(from.view, View.ALPHA, 1f, 0f);
        toAlpha.setDuration(200);
        toAlpha.setInterpolator(new AccelerateDecelerateInterpolator());

        toAlpha.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                onCompleted();
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(toAlpha);
        set.start();
    }
}
