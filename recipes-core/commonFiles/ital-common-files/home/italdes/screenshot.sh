#!/bin/bash
echo ""
echo ""

if [ ! -f /usr/bin/ffmpeg ]
then
	echo "*****  PLEASE Install ffmpeg *****"


else
	echo "***** START screenshot program *****" 

	echo ""

	CURRENTEPOCTIME=`date +"%Y-%m-%g-%H%M%S"`

	if [ ! -d ./screenshots ]
	then
		echo "***** Create a new directory : ./screenshots *****"
		mkdir ./screenshots

	else
		echo "***** save file in: ./screenshots/ *****" 

	fi



	if [ -f ./screenshots/input.raw ]
	then
	echo "   ***** REMOVE ./screenshots/input.raw *****"
	rm ./screenshots/input.raw
	fi

	if [ -f ./screenshots/output.png ]
	then
	echo "   ***** REMOVE ./screenshots/output.png *****"
	rm ./screenshots/output.png
	fi

	if [ -f ./screenshots/output_rot.png ]
	then
	echo "   ***** REMOVE ./screenshots/output_rot.png *****"
	rm ./screenshots/output_rot.png
	fi

	echo ""
	echo "      capture image..."
	cat /dev/fb0 > ./screenshots/input.raw

	echo "      convertion image..."
	ffmpeg -pixel_format rgb565le -s 1024x600 -i ./screenshots/input.raw ./screenshots/output.png &> ./screenshots/ffmpeg_log.out

	echo "      rotate image..."
	ffmpeg -i ./screenshots/output.png -vf "transpose=1" ./screenshots/output_rot.png &> ./screenshots/ffmpeg_rotate_log.out
	echo ""

	echo "***** save image ./screenshots/screen-$CURRENTEPOCTIME.png *****"
	cp ./screenshots/output_rot.png ./screenshots/screen-$CURRENTEPOCTIME.png

	rm ./screenshots/input.raw
	rm ./screenshots/output.png
	rm ./screenshots/output_rot.png

fi
echo ""
echo ""
