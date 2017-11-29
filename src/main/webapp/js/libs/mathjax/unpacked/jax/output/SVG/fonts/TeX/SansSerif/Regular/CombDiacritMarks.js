/*************************************************************
 *
 *  MathJax/jax/output/SVG/fonts/TeX/svg/SansSerif/Regular/CombDiacritMarks.js
 *
 *  Copyright (c) 2011-2016 The MathJax Consortium
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

MathJax.Hub.Insert(
  MathJax.OutputJax.SVG.FONTDATA.FONTS['MathJax_SansSerif'],
  {
    // COMBINING GRAVE ACCENT
    0x300: [694,-527,0,-417,-200,'-415 692L-417 694H-324L-262 612Q-249 594 -233 572T-208 539L-200 528L-237 527H-275L-344 608Q-359 625 -378 647T-406 680T-415 692'],

    // COMBINING ACUTE ACCENT
    0x301: [694,-527,0,-301,-84,'-239 612L-177 694H-84L-86 692Q-86 691 -95 681T-123 648T-157 608L-226 527H-264L-301 528L-293 539Q-285 550 -269 572T-239 612'],

    // COMBINING CIRCUMFLEX ACCENT
    0x302: [694,-527,0,-421,-79,'-354 612L-288 694H-213L-147 612Q-83 532 -80 529Q-79 528 -82 527Q-86 527 -117 527H-155L-250 639Q-256 633 -301 580L-346 527H-384Q-421 528 -421 529Q-418 532 -354 612'],

    // COMBINING TILDE
    0x303: [677,-543,0,-417,-84,'-417 554Q-414 604 -387 640T-314 677Q-289 677 -249 649T-188 620Q-163 620 -160 665V677H-84V666Q-87 608 -118 576T-185 543Q-211 543 -251 571T-313 600Q-338 600 -341 555V543H-417V554'],

    // COMBINING MACRON
    0x304: [631,-552,0,-431,-70,'-431 552V631H-70V552H-431'],

    // COMBINING BREVE
    0x306: [694,-508,0,-427,-74,'-250 508Q-331 508 -379 567T-427 689V694H-351V685Q-348 649 -321 620T-250 591Q-206 591 -180 619T-150 685V694H-74V689Q-74 624 -122 566T-250 508'],

    // COMBINING DOT ABOVE
    0x307: [680,-576,0,-302,-198,'-302 576V680H-198V576H-302'],

    // COMBINING DIAERESIS
    0x308: [680,-582,0,-397,-104,'-397 582V680H-299V582H-397ZM-202 582V680H-104V582H-202'],

    // COMBINING RING ABOVE
    0x30A: [694,-526,0,-319,-99,'-319 611Q-319 649 -285 671T-211 694Q-164 694 -132 671T-99 611Q-99 572 -133 550T-209 527T-285 549T-319 611ZM-155 610Q-155 635 -171 643T-215 651Q-263 651 -263 610Q-263 570 -211 570H-209H-207Q-155 570 -155 610'],

    // COMBINING DOUBLE ACUTE ACCENT
    0x30B: [694,-527,0,-399,-84,'-250 693Q-317 544 -323 527H-399L-343 694H-296Q-250 694 -250 693ZM-84 693Q-151 544 -157 527H-233L-177 694H-130Q-84 694 -84 693'],

    // COMBINING CARON
    0x30C: [654,-487,0,-422,-80,'-421 652Q-422 653 -419 654Q-415 654 -384 654H-346L-301 601Q-287 585 -275 571T-258 551T-250 542L-155 654H-117Q-80 653 -80 652Q-83 649 -147 569L-213 487H-288L-354 569Q-418 649 -421 652']
  }
);

MathJax.Ajax.loadComplete(MathJax.OutputJax.SVG.fontDir+"/SansSerif/Regular/CombDiacritMarks.js");
